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
 * A servlet to edit or delete a note
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/editNote"}
)

public class EditNote extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao noteDao = new GenericDao(Note.class);

        // retrieve note to edit or delete
        Note note = (Note)noteDao.getById(Integer.parseInt(req.getParameter("noteId")));
        Trip trip;
        trip = note.getTrip();

        List<Note> notes = new ArrayList(trip.getNoteSet());
        List<Destination> destinations = new ArrayList(trip.getDestinationSet());

        // check if delete or update button was pressed
        if (req.getParameter("submit").equals("editNote")) {

            String name = req.getParameter("noteName");
            String description = req.getParameter("noteDescription");

            // if name or description are empty then retrieve the previously stored values
            if (name.equals("")) {
                name = note.getName();
            }
            if (description.equals("")) {
                description = note.getDescription();
            }

            // update the note
            note.setName(name);
            note.setDescription(description);
            noteDao.saveOrUpdate(note);
        }
        if (req.getParameter("submit").equals("deleteNote")) {
            noteDao.delete(note);
            notes.remove(note);
        }

        // Send the trip's list of notes and destinations to tripsInfo.jsp
        req.setAttribute("tripInfo", trip);
        req.setAttribute("noteSet", notes);
        req.setAttribute("destinationSet", destinations);
        logger.debug("The noteSet {}", notes);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/tripInfo.jsp");
        dispatcher.forward(req, resp);
    }
}
