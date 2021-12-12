package com.jilleliceiri.mptr.controller;

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

/**
 * A servlet to retrieve specified trip and send it to the Add Note Form
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/addNoteForm"}
)

public class AddNoteForm extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // retrieve the trip and send it to the Add Note Form
        GenericDao genericDao = new GenericDao(Trip.class);
        Trip trip;
        int id = (Integer.parseInt(req.getParameter("tripID")));
        String page = "/addNote.jsp";
        try {
            trip = (Trip)genericDao.getById(id);
            req.setAttribute("trip", trip);
            logger.debug("trip: {}", trip);
        } catch (Exception e){
            page = "/error.jsp";
            logger.error("Error retrieving specified trip", e);
        } finally {
            RequestDispatcher dispatcher = req.getRequestDispatcher(page);
            dispatcher.forward(req, resp);
        }
    }
}

