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
 * A servlet to add a note
 * @author jeliceiri
 */

@WebServlet(
        urlPatterns = {"/addNote"}
)

public class AddNote extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao noteDao = new GenericDao(Note.class);
        GenericDao tripDao = new GenericDao(Trip.class);

        // get the trip id and the note info to add a new note
        String noteName = req.getParameter("noteName");
        String noteDescription = req.getParameter("noteDescription");
        int id = (Integer.parseInt(req.getParameter("tripID")));
        Trip trip = (Trip) tripDao.getById(id);

        // insert new note
        Note newNote = new Note(noteName, noteDescription, trip);
        noteDao.insert(newNote);
        logger.debug("newNote: {}", newNote);

        // get list of notes and destinations to send back to trip info page
        List<Note> notes = new ArrayList(trip.getNoteSet());
        notes.add(newNote);
        List<Destination> destinations = new ArrayList(trip.getDestinationSet());
        req.setAttribute("tripInfo", trip);
        req.setAttribute("noteSet", notes);
        req.setAttribute("destinationSet", destinations);
        logger.debug("tripInfo, noteSet, destinationSet: {} {} {}", trip, notes, destinations);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/tripInfo.jsp");
        dispatcher.forward(req, resp);
    }
}
