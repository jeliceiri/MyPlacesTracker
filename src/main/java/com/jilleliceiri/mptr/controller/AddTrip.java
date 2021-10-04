package com.jilleliceiri.mptr.controller;

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
 * A servlet to add a trip
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/addTrip"}
)

// TODO write property loader interface like adv java

public class AddTrip extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao tripDao = new GenericDao(Trip.class);
        // TODO use generic dao
        Trip newTrip = new Trip(req.getParameter("addTrip"));

        int id = tripDao.insert(newTrip);
        req.setAttribute("trips", tripDao.getAll());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/trips.jsp");
        dispatcher.forward(req, resp);
    }
}
