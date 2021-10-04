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
        urlPatterns = {"/forwardToAddNote"}
)

// TODO write property loader interface like adv java

public class ForwardToAddNote extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // TODO work on this class
        // get the tripID, turn it into a trip, and send it to the AddNoteJSP
        GenericDao genericDao = new GenericDao(Trip.class);
        int id = (Integer.parseInt(req.getParameter("tripID")));
        Trip trip = new Trip();
        trip = (Trip)genericDao.getById(id);
        req.setAttribute("trip", trip);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/addNote.jsp");
        dispatcher.forward(req, resp);

    }
}

