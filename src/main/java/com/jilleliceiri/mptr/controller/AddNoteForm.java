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
 * A servlet to retrieve specified trip and send it to the Add Note Form
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/addNoteForm"}
)

public class AddNoteForm extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get the tripID, turn it into a trip, and send it to the Add Note Form
        GenericDao genericDao = new GenericDao(Trip.class);
        int id = (Integer.parseInt(req.getParameter("tripID")));
        Trip trip = new Trip();
        trip = (Trip)genericDao.getById(id);
        req.setAttribute("trip", trip);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/addNote.jsp");
        dispatcher.forward(req, resp);
    }
}

