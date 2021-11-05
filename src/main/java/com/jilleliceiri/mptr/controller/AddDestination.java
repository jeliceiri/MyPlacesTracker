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
import java.util.ArrayList;
import java.util.List;

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

        // get the id of the trip and the note information to add a new note
        String city = req.getParameter("destinationCity");
        String state = req.getParameter("destinationState");
        int id = (Integer.parseInt(req.getParameter("tripID")));

        // make trip object
        // make trip object
        Trip trip = new Trip();
        trip = (Trip)tripDao.getById(id);

        // get destination info and make Destination object
        SmartyResponseItem[] smartyResponseItems = smartyStreetsDao.getCityResponse(city, state);
        String zipCode = smartyResponseItems[0].getZipcodes().get(0).getZipcode();
        String countyFips = smartyResponseItems[0].getZipcodes().get(0).getCountyFips();

        // TODO get the hospitalCapacity as a percentage String.format("%.2f", input)
        CovidResponse hospitalCapacity = covidDao.getResponse(countyFips);
        String icuCapacityRatio = String.valueOf(hospitalCapacity.getMetrics().getIcuCapacityRatio());

        // insert new destination
        Destination destination = new Destination(city, state, zipCode, countyFips, icuCapacityRatio, trip);
        destinationDao.insert(destination);

        // get list of notes and destinations to send back to trip info page
        List<Note> notes = new ArrayList(trip.getNoteSet());
        List<Destination> destinations = new ArrayList(trip.getDestinationSet());
        destinations.add(destination);
        req.setAttribute("tripInfo", trip);
        req.setAttribute("noteSet", notes);
        req.setAttribute("destinationSet", destinations);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/tripInfo.jsp");
        dispatcher.forward(req, resp);
    }
}
