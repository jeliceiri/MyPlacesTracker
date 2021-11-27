package com.jilleliceiri.mptr.controller;

import com.jilleliceiri.mptr.entity.Destination;
import com.jilleliceiri.mptr.entity.Trip;
import com.jilleliceiri.mptr.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A servlet that retrieves the specified trip and sends it to the Add Destination jsp
 * @author jeliceiri
 */

@WebServlet(
        urlPatterns = {"/addDestinationForm"}
)

public class AddDestinationForm extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao tripDao = new GenericDao(Trip.class);

        // get the tripID, instantiate a trip, and send it to the Add Destination jsp
        int id = (Integer.parseInt(req.getParameter("tripID")));
        Trip trip = (Trip)tripDao.getById(id);
        req.setAttribute("trip", trip);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/addDestination.jsp");
        dispatcher.forward(req, resp);
    }
}

