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
 * A servlet to add a trip
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/editNote"}
)

public class EditNote extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    // TODO
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao noteDao = new GenericDao(Note.class);
        int id = (Integer.parseInt(req.getParameter("noteId")));
        logger.debug("EditNote the id is {}", id );
        // might remove id

        // retrieve note
        Note note = (Note)noteDao.getById(Integer.parseInt(req.getParameter("noteId")));

        // check if delete or update button was pressed
        if (req.getParameter("submit").equals("deleteNote")) {
            noteDao.delete(note);
        } else {

            //Note note = (Note)noteDao.getById(Integer.parseInt(req.getParameter("noteId")));
            String name = req.getParameter("noteName");
            String description = req.getParameter("noteDescription");

            // if name or description are empty then get stored values
            if (name == "") {
                name = note.getName();
            }
            if (description == "") {
                description = note.getDescription();
            }

            // update the note
            note.setName(name);
            note.setDescription(description);
            noteDao.saveOrUpdate(note);
        }
        // TODO need to think about what to do if this is already deleted!
        // Get the trip from this note and send its list of notes and destinations to tripsInfo.jsp
        Trip trip;
        trip = note.getTrip();

        List<Note> notes = new ArrayList(trip.getNoteSet());
        List<Destination> destinations = new ArrayList(trip.getDestinationSet());
        req.setAttribute("tripInfo", trip);
        req.setAttribute("noteSet", notes);
        req.setAttribute("destinationSet", destinations);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/tripInfo.jsp");
        dispatcher.forward(req, resp);
    }
}
