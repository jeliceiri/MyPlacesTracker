package com.jilleliceiri.mptr.persistence;

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

    @Test
    void getAll() {

        // get all
        List<Trip> trips = tripDao.getAll();

        // verify 3 trips were returned
        assertEquals(3, trips.size());
    }



    @Test
    void insertTrip() {
        // create a new book (use the constructor to set all values)
        Trip newTrip = new Trip("Northern Summer");
        // insert new book using dao
        int id = tripDao.insertTrip(newTrip);
        assertNotEquals(0,id);
        // retrieve the trip
        //Trip insertedTrip = tripDao.getById(id);
        // compare values to make sure all values were inserted correctly - assert all fields
        //assertEquals("Core Java Volume I – Fundamentals", insertedBook.getTitle());
        //assertEquals("Cay S. Horstmann", insertedBook.getAuthor());
        //assertEquals("978-0135166307", insertedBook.getIsbn());
        //assertEquals(2018, insertedBook.getPublicationYear());
    }
}