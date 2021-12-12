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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
 *
 * @author jeliceiri
 */
@WebServlet(
        urlPatterns = {"/addDestination"}
)

public class AddDestination extends HttpServlet {

    GenericValidator genericValidator = new GenericValidator(Object.class);
    GenericDao destinationDao = new GenericDao(Destination.class);
    GenericDao tripDao = new GenericDao(Trip.class);
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = "/tripInfo.jsp";
        Trip trip;
        Destination destination;
        String city = req.getParameter("destinationCity");
        String state = req.getParameter("destinationState");
        int id = (Integer.parseInt(req.getParameter("tripID")));
        try {
            trip = (Trip) tripDao.getById(id);
            // validate Destination's city and state fields
            destination = new Destination(city, state, "", "", "", "", trip);
            Validator validator = ValidatorFactory.init();
            List<String> errors = genericValidator.validate(destination, validator);
            if (!errors.isEmpty()) {
                req.setAttribute("errMsg", errors);
                req.setAttribute("trip", trip);
                page = "/addDestination.jsp";
                forwardDispatcher(req, resp, page);
            } else {
                setDestinationFields(destination, city, state, req, resp, trip, page);
            }
        } catch (Exception e) {
            page = "/error.jsp";
            logger.error("Not able to Add Destination", e);
        } finally {
            forwardDispatcher(req, resp, page);
        }
    }

    // set the destination fields: zip code, county fips and local icu capacity
    private void setDestinationFields(Destination destination, String city, String state, HttpServletRequest req,
                                      HttpServletResponse resp, Trip trip, String page) throws ServletException, IOException {
        SmartyResponseItem[] smartyResponseItems;
        try {
            smartyResponseItems = getSmartyResponse(city, state);
            destination.setZipCode(smartyResponseItems[0].getZipcodes().get(0).getZipcode());
            destination.setCountyFipsCode(smartyResponseItems[0].getZipcodes().get(0).getCountyFips());
            destination.setCountyHospitalCapacity(getLocalHealthInfo(destination.getCountyFipsCode()));
            destination.setRisk(getLocalRiskLevel(destination.getCountyFipsCode()));

            // insert new destination
            destinationDao.insert(destination);

            // get list of notes and destinations to send back to trip info page
            Set<Note> notes = trip.getNoteSet();
            Set<Destination> destinations = trip.getDestinationSet();
            destinations.add(destination);
            req.setAttribute("tripInfo", trip);
            req.setAttribute("noteSet", notes);
            req.setAttribute("destinationSet", destinations);
            logger.debug("tripInfo, noteSet, and destinationSet: {} {} {}", trip, notes, destinations);
        } catch (Exception e) {
            String errMsg = "Something went wrong please try again";
            req.setAttribute("errMsg", errMsg);
            req.setAttribute("trip", trip);
            logger.error("error message and trip: {} {}", errMsg, trip);
            logger.error("exception: {}", e);
            page = "/addDestination.jsp";
            forwardDispatcher(req, resp, page);
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
        return smartyStreetsDao.getCityResponse(city, state);
    }

    /**
     * Gets ICU capcacity from Covid Act Now RESTful API
     *
     * @param countyFips the county fips
     * @return the local health info ICU capcacity
     */

    protected String getLocalHealthInfo(String countyFips) {
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

    /**
     * Gets local risk level from Covid Act Now RESTful API
     *
     * @param fips the fips
     * @return the local risk level
     */

    protected String getLocalRiskLevel(String fips) {
        CovidDao dao = new CovidDao();
        String risk;
        CovidResponse covidResponse = dao.getResponse(fips);
        int riskInt = covidResponse.getRiskLevels().getOverall();
        if (riskInt == 0) {
            risk = "low";
        } else if (riskInt == 1) {
            risk = "medium";
        } else if (riskInt == 2) {
            risk = "high";
        } else if (riskInt == 3) {
            risk = "very high";
        } else if (riskInt == 4) {
            risk = "severe";
        } else risk = "N/A";
        return risk;
    }
}