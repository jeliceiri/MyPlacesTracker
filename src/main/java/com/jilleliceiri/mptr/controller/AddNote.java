package com.jilleliceiri.mptr.controller;

import com.jilleliceiri.mptr.entity.Destination;
import com.jilleliceiri.mptr.entity.Note;
import com.jilleliceiri.mptr.entity.Trip;
import com.jilleliceiri.mptr.persistence.GenericDao;
import com.jilleliceiri.mptr.util.GenericValidator;
import com.jilleliceiri.mptr.util.ValidatorFactory;
import jakarta.validation.Validator;
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
 *
 * @author jeliceiri
 */

@WebServlet(
        urlPatterns = {"/addNote"}
)

public class AddNote extends HttpServlet {

    /**
     * The Generic validator.
     */
    GenericValidator genericValidator = new GenericValidator(Object.class);
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String page = "/tripInfo.jsp";
        GenericDao noteDao = new GenericDao(Note.class);
        GenericDao tripDao = new GenericDao(Trip.class);

        // get the trip id and the note info to add a new note
        String noteName = req.getParameter("noteName");
        String noteDescription = req.getParameter("noteDescription");
        int id = (Integer.parseInt(req.getParameter("tripID")));

        try {
            Trip trip = (Trip) tripDao.getById(id);
            // validate the note
            Note newNote = new Note(noteName, noteDescription, trip);
            logger.debug("newNote: {}", newNote);
            Validator validator = ValidatorFactory.init();
            List<String> errors = genericValidator.validate(newNote, validator);
            if (errors.isEmpty()) {
                // insert new note
                noteDao.insert(newNote);
                // get list of notes and destinations to send back to trip info page
                List<Note> notes = new ArrayList(trip.getNoteSet());
                notes.add(newNote);
                List<Destination> destinations = new ArrayList(trip.getDestinationSet());
                req.setAttribute("tripInfo", trip);
                req.setAttribute("noteSet", notes);
                req.setAttribute("destinationSet", destinations);
                logger.debug("tripInfo, noteSet, destinationSet: {} {} {}", trip, notes, destinations);
            } else {
                page = "/addNote.jsp";
                req.setAttribute("errMsg", errors);
                req.setAttribute("trip", trip);
            }
        } catch (Exception e) {
            page = "/error.jsp";
            logger.error("Error adding note", e);
        } finally {
            RequestDispatcher dispatcher = req.getRequestDispatcher(page);
            dispatcher.forward(req, resp);
        }
    }
}
