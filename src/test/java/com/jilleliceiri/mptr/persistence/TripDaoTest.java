package com.jilleliceiri.mptr.persistence;

import com.jilleliceiri.mptr.entity.Destination;
import com.jilleliceiri.mptr.entity.Note;
import com.jilleliceiri.mptr.entity.Trip;
import com.jilleliceiri.mptr.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Trip dao test.
 */
class TripDaoTest {


    /**
     * The Generic dao.
     */
    GenericDao genericDao;
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(Trip.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies getById successfully runs
     */
    @Test
    void getByIdSuccess() {
        Trip retrievedTrip = (Trip)genericDao.getById(1);
        assertEquals("Fall  Colour Tour", retrievedTrip.getName());
        assertEquals(2, retrievedTrip.getDestinationSet().size());
    }
    /**
     * Verifies getAll trips successfully runs
     */
    @Test
    void getAllTripsSuccess(){
        List<Trip> trips = genericDao.getAll();
        assertEquals(3, trips.size());
    }

    /**
     * Vefify delete trip successfully runs
     */
    @Test
    void deleteSuccess(){
        genericDao.delete(genericDao.getById(2));
        assertNull(genericDao.getById(2));
    }

    /**
     * Verify saveOrUpdate successfully runs
     */
    @Test
    void saveOrUpdateSuccess() {
        String tripName = "New Trip Name";
        // retrieve a trip to update
        Trip tripToUpdate = (Trip)genericDao.getById(3);
        // change the trip name
        tripToUpdate.setName(tripName);
        // save the changes
        genericDao.saveOrUpdate(tripToUpdate);
        // retrieve the same trip
        Trip retrievedTrip = (Trip)genericDao.getById(3);
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
        int id = genericDao.insert(newTrip);
        assertNotEquals(0,id);
        // retrieve trip
        Trip retrievedTrip = (Trip)genericDao.getById(id);
        // compare trips using all fields of entity
        assertEquals(newTrip, retrievedTrip);
    }

    /**
     * Verify insert a trip with a destination successfully runs
     */
    @Test
    void insertTripWithDestinationsSuccess() {
        // put destination on trip and trip on destination
        Trip newTrip = new Trip("Northern Summer");
        String destinationName = "Minneapolis";
        Destination destination = new Destination(destinationName, newTrip);
        // nice to have method that does the set destinations
        newTrip.addDestination(destination);

        // insert new trip using dao
        int id = genericDao.insert(newTrip);
        // retrieve the inserted trip
        Trip insertedTrip = (Trip)genericDao.getById(id);
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
        int id = genericDao.insert(newTrip);
        // retrieve the inserted trip
        Trip insertedTrip = (Trip)genericDao.getById(id);
        // compare trips using all fields of entity
        assertTrue(insertedTrip.equals(newTrip));
    }

}