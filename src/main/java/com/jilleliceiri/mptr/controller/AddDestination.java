package com.jilleliceiri.mptr.controller;

import com.covidactnow.CovidResponse;
import com.jilleliceiri.mptr.entity.Destination;
import com.jilleliceiri.mptr.entity.Note;
import com.jilleliceiri.mptr.entity.Trip;
import com.jilleliceiri.mptr.persistence.CovidDao;
import com.jilleliceiri.mptr.persistence.GenericDao;
import com.jilleliceiri.mptr.persistence.SmartyStreetsDao;
import com.smartystreets.SmartyResponseItem;

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
 * A servlet to add a note
 * @author jeliceiri
 */

@WebServlet(
        urlPatterns = {"/addDestination"}
)

public class AddDestination extends HttpServlet {

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao destinationDao = new GenericDao(Destination.class);
        GenericDao tripDao = new GenericDao(Trip.class);
        SmartyStreetsDao smartyStreetsDao = new SmartyStreetsDao();
        CovidDao covidDao = new CovidDao();

        // get the city and state for finding the zip code and fips code along with trip ID
        String city = req.getParameter("destinationCity");
        String state = req.getParameter("destinationState");
        int id = (Integer.parseInt(req.getParameter("tripID")));

        // instantiate trip object
        Trip trip = (Trip)tripDao.getById(id);

        // get destination zip code and county fips code for Destination object
        SmartyResponseItem[] smartyResponseItems = smartyStreetsDao.getCityResponse(city, state);
        String zipCode = smartyResponseItems[0].getZipcodes().get(0).getZipcode();
        String countyFips = smartyResponseItems[0].getZipcodes().get(0).getCountyFips();

        // check if ICU Capacity is null or 0 (data not available), otherwise format as percent
        CovidResponse localHealthInfo = covidDao.getResponse(countyFips);
        Double icuCapacityRatio = localHealthInfo.getMetrics().getIcuCapacityRatio();
        String percentage;
        if (icuCapacityRatio == null || icuCapacityRatio == 0){
            percentage = "N/A";
        } else {
            NumberFormat format = NumberFormat.getPercentInstance(Locale.US);
            percentage = format.format(icuCapacityRatio);
        }

        // insert new destination
        Destination destination = new Destination(city, state, zipCode, countyFips, percentage, trip);
        destinationDao.insert(destination);

        // get list of notes and destinations to send back to trip info page
        Set<Note> notes = trip.getNoteSet();
        Set<Destination> destinations = trip.getDestinationSet();
        //List<Destination> destinations = new ArrayList(trip.getDestinationSet());
        destinations.add(destination);
        req.setAttribute("tripInfo", trip);
        req.setAttribute("noteSet", notes);
        req.setAttribute("destinationSet", destinations);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/tripInfo.jsp");
        dispatcher.forward(req, resp);
    }
}