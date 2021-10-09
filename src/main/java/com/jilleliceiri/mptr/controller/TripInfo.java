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
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/tripInfo"}
)

public class TripInfo extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get the tripID, turn it into a trip, and send it to the TripInfo jsp
        GenericDao genericDao = new GenericDao(Trip.class);

        int id = (Integer.parseInt(req.getParameter("tripID")));
        logger.debug("Getting Trip ID: {}", id);
        Trip tripInfo = new Trip();
        tripInfo = (Trip)genericDao.getById(id);
        req.setAttribute("tripInfo", tripInfo);
        List<Note> notes = new ArrayList(tripInfo.getNoteSet());
        List<Destination> destinations = new ArrayList(tripInfo.getDestinationSet());
        logger.debug("The list of notes: {}", notes);
        logger.debug("The list of destinations: {}", destinations);
        req.setAttribute("noteSet", notes);
        req.setAttribute("destinationSet", destinations);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/tripInfo.jsp");
        dispatcher.forward(req, resp);
    }
}
