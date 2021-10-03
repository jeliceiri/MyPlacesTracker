package com.jilleliceiri.mptr.persistence;

import com.jilleliceiri.mptr.entity.Note;
import com.jilleliceiri.mptr.entity.Trip;
import com.jilleliceiri.mptr.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NoteDaoTest {

    GenericDao genericDao;
    GenericDao tripDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(Note.class);
        tripDao = new GenericDao(Trip.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies getById note successfully runs
     */
    @Test
    void getByIdSuccess() {
        Note retrievedNote = (Note)genericDao.getById(1);
        assertEquals("ABC Hotel", retrievedNote.getName());
        assertEquals("2021 Fall Colour Tour St.", retrievedNote.getDescription());
        assertEquals(1, retrievedNote.getTrip().getId());
    }
// TODO LOGS
    /**
     * Verifies getAll notes successfully runs
     */
    @Test
    void getAllNotesSuccess(){
        List<Note> notes = genericDao.getAll();
        assertEquals(2, notes.size());
    }

    /**
     * Verify saveOrUpdate successfully runs
     */
    @Test
    void saveOrUpdateSuccess() {
        String noteName = "New Note Name";
        // retrieve a note to update
        Note noteToUpdate = (Note)genericDao.getById(2);
        // change the note name
        noteToUpdate.setName(noteName);
        // save the changes
        genericDao.saveOrUpdate(noteToUpdate);
        // retrieve the same note
        Note retrievedNote = (Note)genericDao.getById(2);
        // verify changes were made
        assertEquals(noteToUpdate, retrievedNote);
    }

    /**
     * Verify insert note successfully runs
     */
    @Test
    void insertNoteWithTripSuccess() {
        // retrieve a trip
        Trip retrievedTrip = (Trip)tripDao.getById(2);
        // create a new note (use the constructor to set all values)
        Note newNote = new Note("insert New Note", "description", retrievedTrip);
        // insert new note using dao
        int id = genericDao.insert(newNote);
        assertNotEquals(0,id);
        // retrieve note
        Note retrievedNote = (Note)genericDao.getById(id);
        // compare notes using all fields of entity
        assertEquals(newNote, retrievedNote);
    }

    /**
     * Vefify delete note successfully runs
     */
    @Test
    void deleteSuccess(){
        genericDao.delete(genericDao.getById(2));
        assertNull(genericDao.getById(2));
    }
}
