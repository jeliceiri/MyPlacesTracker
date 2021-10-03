package com.jilleliceiri.mptr.controller;

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
        urlPatterns = {"/addNote"}
)

// TODO write property loader interface like adv java

public class AddNote extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// TODO work on this class
        //GenericDao genericDaoDao = new GenericDao();
/*
        Trip newTrip = new Trip(req.getParameter("addTrip"));
        Note newNote = new Note(req.getParameter("noteName"),req.getParameter("noteDescription"),  );

        int id = genericDaoDao.insert(newTrip);
        req.setAttribute("trips", tripDao.getAll());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/trips.jsp");
        dispatcher.forward(req, resp);
    }
    */


    }
}

