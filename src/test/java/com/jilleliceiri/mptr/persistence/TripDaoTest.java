package com.jilleliceiri.mptr.persistence;

import com.jilleliceiri.mptr.entity.Destination;
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

/**
 * The type Trip dao test.
 */
class TripDaoTest {


    GenericDao tripDao;
    GenericDao noteDao;
    GenericDao destinationDao;

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        tripDao = new GenericDao(Trip.class);
        noteDao = new GenericDao(Note.class);
        destinationDao = new GenericDao(Destination.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies getById successfully runs
     */
    @Test
    void getByIdSuccess() {
        Trip retrievedTrip = (Trip) tripDao.getById(1);
        assertEquals("Fall  Colour Tour", retrievedTrip.getName());
        assertEquals(2, retrievedTrip.getDestinationSet().size());
    }

    /**
     * Verifies getAll trips successfully runs
     */
    @Test
    void getAllTripsSuccess(){
        List<Trip> trips = tripDao.getAll();
        assertEquals(3, trips.size());
    }

    /**
     * Vefify delete trip successfully runs
     */
    @Test
    void deleteSuccess(){
        tripDao.delete(tripDao.getById(1));
        assertNull(tripDao.getById(1));

        // check that this notes are deleted also
        assertNull(noteDao.getById(1));
        assertNull(noteDao.getById(2));

        // check that destinations are deleted also
        assertNull(destinationDao.getById(1));
        assertNull(destinationDao.getById(2));
    }

    /**
     * Verify saveOrUpdate successfully runs
     */
    @Test
    void saveOrUpdateSuccess() {
        String tripName = "New Trip Name";
        // retrieve a trip to update
        Trip tripToUpdate = (Trip) tripDao.getById(3);
        // change the trip name
        tripToUpdate.setName(tripName);
        // save the changes
        tripDao.saveOrUpdate(tripToUpdate);
        // retrieve the same trip
        Trip retrievedTrip = (Trip) tripDao.getById(3);
        // verify changes were made
        assertEquals(tripToUpdate, retrievedTrip);
    }


    /**
     * Verify insert trip successfully runs
     */
    @Test
    void insertTripSuccess() {
        // create a new trip (use the constructor to set all values)
        Trip newTrip = new Trip("Northern Summer");
        // insert new book using dao
        int id = tripDao.insert(newTrip);
        assertNotEquals(0,id);
        // retrieve trip
        Trip retrievedTrip = (Trip) tripDao.getById(id);
        // compare trips using all fields of entity
        assertEquals(newTrip, retrievedTrip);
    }

    /**
     * Verify insert a trip with a destination successfully runs
     */
    @Test
    void insertTripWithDestinationsSuccess() {
        // put destination on trip and trip on destination
        Trip newTrip = new Trip("Wisconsin Summer");
        Destination newDestination = new Destination("Waunakee", "WI", "53597", "55025", "95", newTrip);
        // nice to have method that does the set destinations
        newTrip.addDestination(newDestination);

        // insert new trip using dao
        int id = tripDao.insert(newTrip);
        // retrieve the inserted trip
        Trip insertedTrip = (Trip) tripDao.getById(id);
        // compare trips using all fields of entity
        assertTrue(insertedTrip.equals(newTrip));
    }

    /**
     * Verify insert a trip with a note successfully runs
     */
    @Test
    void insertTripWithNotesSuccess() {
        // put note on trip and trip on note
        Trip newTrip = new Trip("New Trip");
        String noteName = "New Note";
        String noteDescription = "New Note Description";
        Note newNote = new Note(noteName, noteDescription, newTrip);
        // nice to have method that does the set destinations
        newTrip.addNote(newNote);

        // insert new trip using dao
        int id = tripDao.insert(newTrip);
        // retrieve the inserted trip
        Trip insertedTrip = (Trip) tripDao.getById(id);
        // compare trips using all fields of entity
        assertTrue(insertedTrip.equals(newTrip));
    }

}