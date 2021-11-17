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
 * The type Destination dao test.
 */
public class DestinationDaoTest {

    /**
     * The Destination dao.
     */
    GenericDao destinationDao;
    /**
     * The Trip dao.
     */
    GenericDao tripDao;

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
        destinationDao = new GenericDao(Destination.class);
        tripDao = new GenericDao(Trip.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    // TODO: look again at getAllNotes - should be just for a particular trip
    // TODO: look again at getAllDestinations - should be just for a particular trip

    /**
     * Verifies getAll destinations successfully runs
     *
     * @throws Exception the exception
     */
    @Test
    void getAllDestinationsSuccess()throws Exception {
        List<Destination> destinations = destinationDao.getAll();
        assertEquals(4, destinations.size());
    }

    /**
     * Verify saveOrUpdate successfully runs
     *
     * @throws Exception the exception
     */
    @Test
    void saveOrUpdateSuccess() throws Exception {
        String city = "Waunakee";
        String state = "WI";
        String zipCode = "53597";
        String countyFipsCode = "55025";
        String countyHospitalCapacity = "95";

        // retrieve a destination to update
        Destination destinationToUpdate = (Destination) destinationDao.getById(2);
        // change the fields
        destinationToUpdate.setCity(city);
        destinationToUpdate.setState(state);
        destinationToUpdate.setZipCode(zipCode);
        destinationToUpdate.setCountyFipsCode(countyFipsCode);
        destinationToUpdate.setCountyHospitalCapacity(countyHospitalCapacity);
        // save the changes
        destinationDao.saveOrUpdate(destinationToUpdate);
        // retrieve the same note
        Destination retrievedDestination = (Destination) destinationDao.getById(2);
        // verify changes were made
        assertEquals(destinationToUpdate, retrievedDestination);
    }

    /**
     * Verify insert destination successfully runs
     *
     * @throws Exception the exception
     */
    @Test
    void insertDestinationWithTripSuccess() throws Exception {
        // retrieve a trip
        Trip retrievedTrip = (Trip)tripDao.getById(2);
        // create a new destination (use the constructor to set all values)
        Destination newDestination = new Destination("Waunakee", "WI", "53597", "55025", "95", retrievedTrip);
        // insert new destination using dao
        int id = destinationDao.insert(newDestination);
        assertNotEquals(0,id);
        // retrieve destination
        Destination retrievedDestination = (Destination)destinationDao.getById(id);
        // compare notes using all fields of entity
        assertEquals(newDestination, retrievedDestination);
    }

    /**
     * Vefify delete destination successfully runs
     *
     * @throws Exception the exception
     */
    @Test
    void deleteSuccess()throws Exception {
        // retrieve a trip
        Trip trip = (Trip)tripDao.getById(1);
        // delete a destination attached to the trip
        destinationDao.delete(destinationDao.getById(1));
        assertNull(destinationDao.getById(1));
        // retrieve the trip again to verify it exists
        Trip retrievedTrip = (Trip)tripDao.getById(1);
        assertEquals(trip, retrievedTrip);
    }
}
