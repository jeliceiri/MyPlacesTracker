package com.jilleliceiri.mptr.controller;

import com.covidactnow.CovidResponse;
import com.jilleliceiri.mptr.entity.Destination;
import com.jilleliceiri.mptr.entity.Note;
import com.jilleliceiri.mptr.entity.Trip;
import com.jilleliceiri.mptr.persistence.CovidDao;
import com.jilleliceiri.mptr.persistence.GenericDao;
import com.jilleliceiri.mptr.persistence.SmartyStreetsDao;
import com.jilleliceiri.mptr.util.GenericValidator;
import com.jilleliceiri.mptr.util.ValidatorFactory;
import com.smartystreets.SmartyResponseItem;
import jakarta.validation.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;

/**
 * A servlet that adds a new Destination
 * @author jeliceiri
 */
@WebServlet(
        urlPatterns = {"/addDestination"}
)

public class AddDestination extends HttpServlet {

    /**
     * The Generic validator.
     */
    GenericValidator genericValidator = new GenericValidator(Object.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String page = "/tripInfo.jsp";
        GenericDao destinationDao = new GenericDao(Destination.class);
        GenericDao tripDao = new GenericDao(Trip.class);

        String city = req.getParameter("destinationCity");
        String state = req.getParameter("destinationState");
        int id = (Integer.parseInt(req.getParameter("tripID")));
        Trip trip = (Trip) tripDao.getById(id);

        // validate Destination's city and state fields
        Destination destination = new Destination(city, state, "", "", "", trip);
        Validator validator = ValidatorFactory.init();
        List<String> errors = genericValidator.validate(destination, validator);
        if (!errors.isEmpty()) {
            req.setAttribute("errMsg", errors);
            req.setAttribute("trip", trip);
            page = "/addDestination.jsp";
            forwardDispatcher(req, resp, page);
        } else {
            // set the zip code, county fips, and local icu capacity fields on Destination object
            SmartyResponseItem[] smartyResponseItems = new SmartyResponseItem[0];
            try {
                smartyResponseItems = getSmartyResponse(city, state);
                destination.setZipCode(smartyResponseItems[0].getZipcodes().get(0).getZipcode());
                destination.setCountyFipsCode(smartyResponseItems[0].getZipcodes().get(0).getCountyFips());
                destination.setCountyHospitalCapacity(getLocalHealthInfo(destination.getCountyFipsCode()));

                // insert new destination
                destinationDao.insert(destination);

                // get list of notes and destinations to send back to trip info page
                Set<Note> notes = trip.getNoteSet();
                Set<Destination> destinations = trip.getDestinationSet();
                destinations.add(destination);
                req.setAttribute("tripInfo", trip);
                req.setAttribute("noteSet", notes);
                req.setAttribute("destinationSet", destinations);
            } catch (Exception e) {
                req.setAttribute("errMsg", "something went wrong, please try again");
                req.setAttribute("trip", trip);
                page = "/addDestination.jsp";
            } finally {
                forwardDispatcher(req, resp, page);
            }
        }
    }

    // send to result page
    private void forwardDispatcher(HttpServletRequest req, HttpServletResponse resp, String page) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(page);
        dispatcher.forward(req, resp);
    }

    // get response from SmartyStreets RESTful API
    private SmartyResponseItem[] getSmartyResponse(String city, String state) {
        SmartyStreetsDao smartyStreetsDao = new SmartyStreetsDao();
        SmartyResponseItem[] smartyResponseItems = smartyStreetsDao.getCityResponse(city, state);
        return smartyResponseItems;
    }

    // get response from Covid Act Now RESTful API
    private String getLocalHealthInfo(String countyFips) {
        CovidDao covidDao = new CovidDao();
        CovidResponse localHealthInfo = covidDao.getResponse(countyFips);
        Double icuCapacityRatio = localHealthInfo.getMetrics().getIcuCapacityRatio();
        String icuPercentage;
        // check if ICU Capacity is null or 0 (data not available), otherwise format as percent
        if (icuCapacityRatio == null || icuCapacityRatio == 0) {
            icuPercentage = "N/A";
        } else {
            NumberFormat format = NumberFormat.getPercentInstance(Locale.US);
            icuPercentage = format.format(icuCapacityRatio);
        }
        return icuPercentage;
    }
}