package com.jilleliceiri.mptr.controller;

import com.jilleliceiri.mptr.entity.Note;
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

/**
 * A servlet to retrieve specified note and send it to the Edit Note Form
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/editNoteForm"}
)

public class EditNoteForm extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get the noteId, retrieve the specified note, and send it to the Edit Note form
        GenericDao noteDao = new GenericDao(Note.class);
        int id = (Integer.parseInt(req.getParameter("noteId")));
        logger.debug("ForwardToEditNote the id is {}", id );

        Note note;
        note = (Note)noteDao.getById(id);
        logger.debug("ForwardToEditNote the note is {}", note );

        req.setAttribute("note", note);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/editNote.jsp");
        dispatcher.forward(req, resp);
    }
}

