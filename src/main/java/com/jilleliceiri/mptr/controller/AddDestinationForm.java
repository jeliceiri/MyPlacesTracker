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
 * A servlet that retrieves the specified trip and sends it to the Add Destination jsp
 *
 * @author jeliceiri
 */

@WebServlet(
        urlPatterns = {"/addDestinationForm"}
)

public class AddDestinationForm extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve the specified trip and send it to the Add Destination form
        GenericDao tripDao = new GenericDao(Trip.class);
        int id = (Integer.parseInt(req.getParameter("tripID")));
        String page = "/addDestination.jsp";
        try {
            Trip trip = (Trip) tripDao.getById(id);
            req.setAttribute("trip", trip);
            logger.debug("trip: {}", trip);
        } catch (Exception e) {
            page = "/error.jsp";
            logger.error("Error retrieving specified trip", e);
        } finally {
            RequestDispatcher dispatcher = req.getRequestDispatcher(page);
            dispatcher.forward(req, resp);
        }
    }
}

