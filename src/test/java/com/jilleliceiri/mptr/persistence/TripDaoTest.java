package com.jilleliceiri.mptr.persistence;

import com.jilleliceiri.mptr.entity.Destination;
import com.jilleliceiri.mptr.entity.Trip;
import com.jilleliceiri.mptr.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TripDaoTest {

    TripDao tripDao;

    @BeforeEach
    void setUp() {
        tripDao = new TripDao();
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies getById successfully runs.
     */
    @Test
    void getByIdSuccess() {
        Trip retrievedTrip = tripDao.getById(1);
        assertEquals("Fall  Colour Tour", retrievedTrip.getName());
        assertEquals(2, retrievedTrip.getDestinationSet().size());
    }

    @Test
    void getAll() {

        // get all
        List<Trip> trips = tripDao.getAll();

        // verify 3 trips were returned
        assertEquals(3, trips.size());
    }



    @Test
    void insertTripSuccess() {
        // create a new book (use the constructor to set all values)
        Trip newTrip = new Trip("Northern Summer");
        // insert new book using dao
        int id = tripDao.insertTrip(newTrip);
        assertNotEquals(0,id);
        // retrieve trip
        // compare trip
    }

    @Test
    void insertTripWithDestinationsSuccess() {
        // put destination on trip and trip on destination
        Trip newTrip = new Trip("Northern Summer");
        String destinationName = "Minneapolis";
        Destination destination = new Destination(destinationName, newTrip);
        // nice to have method that does the set destinations
        newTrip.addDestination(destination);

        // insert new trip using dao
        int id = tripDao.insertTrip(newTrip);
        // TODO get by ID method
        Trip insertedTrip = tripDao.getById(id);
        assertNotEquals(0,id);
        // verify destination is in there
        assertEquals(1, insertedTrip.getDestinationSet().size());
        // retrieve trip
        // compare trip
    }
}