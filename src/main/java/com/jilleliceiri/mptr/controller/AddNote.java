package com.jilleliceiri.mptr.controller;

import com.jilleliceiri.mptr.entity.Destination;
import com.jilleliceiri.mptr.entity.Note;
import com.jilleliceiri.mptr.entity.Trip;
import com.jilleliceiri.mptr.persistence.GenericDao;

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
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/addNote"}
)

public class AddNote extends HttpServlet {

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get the id of the trip and the note information to add a new note
        GenericDao noteDao = new GenericDao(Note.class);
        GenericDao tripDao = new GenericDao(Trip.class);

        String noteName = req.getParameter("noteName");
        String noteDescription = req.getParameter("noteDescription");
        int id = (Integer.parseInt(req.getParameter("tripID")));

        // make trip object
        Trip trip = new Trip();
        trip = (Trip)tripDao.getById(id);

        // insert new note
        Note newNote = new Note(noteName, noteDescription, trip);
        noteDao.insert(newNote);

        List<Note> notes = new ArrayList(trip.getNoteSet());
        List<Destination> destinations = new ArrayList(trip.getDestinationSet());

        // go back to tripinfo
        req.setAttribute("tripInfo", trip);
        req.setAttribute("noteSet", notes);
        req.setAttribute("destinationSet", destinations);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/tripInfo.jsp");
        dispatcher.forward(req, resp);
    }
}
