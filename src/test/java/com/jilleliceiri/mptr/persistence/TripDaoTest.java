package com.jilleliceiri.mptr.persistence;

import com.jilleliceiri.mptr.entity.Destination;
import com.jilleliceiri.mptr.entity.Note;
import com.jilleliceiri.mptr.entity.Trip;
import com.jilleliceiri.mptr.entity.User;
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


    /**
     * The Trip dao.
     */
    GenericDao tripDao;
    /**
     * The Note dao.
     */
    GenericDao noteDao;
    /**
     * The Destination dao.
     */
    GenericDao destinationDao;

    GenericDao userDao;

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
        tripDao = new GenericDao(Trip.class);
        noteDao = new GenericDao(Note.class);
        destinationDao = new GenericDao(Destination.class);
        userDao = new GenericDao(User.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies getById successfully runs
     *
     * @throws Exception the exception
     */
    @Test
    void getByIdSuccess() throws Exception {
        Trip retrievedTrip = (Trip) tripDao.getById(1);
        assertEquals("Fall  Colour Tour", retrievedTrip.getName());
        assertEquals(2, retrievedTrip.getDestinationSet().size());
    }

    /**
     * Verifies getAll trips successfully runs
     *
     * @throws Exception the exception
     */
    @Test
    void getAllTripsSuccess()throws Exception {
        List<Trip> trips = tripDao.getAll();
        assertEquals(3, trips.size());
    }

    /**
     * Vefify delete trip successfully runs
     *
     * @throws Exception the exception
     */
    @Test
    void deleteSuccess()throws Exception {
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
     *
     * @throws Exception the exception
     */
    @Test
    void saveOrUpdateSuccess() throws Exception {
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
     *
     * @throws Exception the exception
     */
    @Test
    void insertTripSuccess() throws Exception {
        // create a new trip (use the constructor to set all values)
        User user = (User)userDao.getById(1);
        Trip newTrip = new Trip("Northern Summer", user);
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
     *
     * @throws Exception the exception
     */
    @Test
    void insertTripWithDestinationsSuccess() throws Exception {
        // put destination on trip and trip on destination
        User user = (User)userDao.getById(1);
        Trip newTrip = new Trip("Wisconsin Summer", user);
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
     *
     * @throws Exception the exception
     */
    @Test
    void insertTripWithNotesSuccess() throws Exception {
        // put note on trip and trip on note
        User user = (User)userDao.getById(1);
        Trip newTrip = new Trip("New Trip", user);
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