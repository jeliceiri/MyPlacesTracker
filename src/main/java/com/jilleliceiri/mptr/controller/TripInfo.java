package com.jilleliceiri.mptr.controller;

import com.jilleliceiri.mptr.entity.Destination;
import com.jilleliceiri.mptr.entity.Note;
import com.jilleliceiri.mptr.entity.Trip;
import com.jilleliceiri.mptr.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
 * A servlet to view info about a trip - its destinations and notes
 *
 * @author pwaite
 */
@WebServlet(
        urlPatterns = {"/tripInfo"}
)

public class TripInfo extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get the tripID, instantiate the Trip, get its destinations and notes, and send to trip info jsp
        GenericDao genericDao = new GenericDao(Trip.class);
        int id = (Integer.parseInt(req.getParameter("tripID")));
        Trip tripInfo = (Trip)genericDao.getById(id);
        List<Note> notes = new ArrayList(tripInfo.getNoteSet());
        List<Destination> destinations = new ArrayList(tripInfo.getDestinationSet());
        logger.debug("The tripInfo: {}", tripInfo);
        logger.debug("The list of notes: {}", notes);
        logger.debug("The list of destinations: {}", destinations);
        // check if refresh destinations button was pressed
        if (req.getParameter("submit").equals("Refresh")) {
            refreshDestinations(destinations, req);
        }
        req.setAttribute("tripInfo", tripInfo);
        req.setAttribute("noteSet", notes);
        req.setAttribute("destinationSet", destinations);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/tripInfo.jsp");
        dispatcher.forward(req, resp);
    }

    private void refreshDestinations(List<Destination> destinations, HttpServletRequest req) {
        AddDestination addDestination = new AddDestination();
        GenericDao destinationDao = new GenericDao(Destination.class);
        String refreshed = "Destinations information has been refreshed.";
        // update the local hospital capacity field and risk field data
        for (Destination destination : destinations) {
            String fips = destination.getCountyFipsCode();
            String icuPercentage = addDestination.getLocalHealthInfo(fips);
            String risk = addDestination.getLocalRiskLevel(fips);
            destination.setCountyHospitalCapacity(icuPercentage);
            destination.setRisk(risk);
            destinationDao.saveOrUpdate(destination);
        }
        req.setAttribute("refreshed", refreshed);
    }
}
