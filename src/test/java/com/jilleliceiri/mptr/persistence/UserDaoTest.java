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
 * The type User dao test.
 */
class UserDaoTest {


    GenericDao userDao;
    GenericDao tripDao;

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        userDao = new GenericDao(User.class);
        tripDao = new GenericDao(Trip.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies getById successfully runs
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User) userDao.getById(1);
        assertEquals("jilltest", retrievedUser.getUsername());
    }

    /**
     * Verifies getAll users successfully runs
     */
    @Test
    void getAllUsersSuccess(){
        List<User> retrievedUsers = userDao.getAll();
        assertEquals(2, retrievedUsers.size());
    }

    /**
     * Verify delete user successfully runs
     */
    @Test
    void deleteSuccess(){
        userDao.delete(userDao.getById(1));
        assertNull(userDao.getById(1));

        // check that users trips are deleted also
        assertNull(tripDao.getById(1));
        assertNull(tripDao.getById(2));
    }

    /**
     * Verify saveOrUpdate successfully runs
     */
    @Test
    void saveOrUpdateSuccess() {
        String userName = "New User Name";
        // retrieve a user to update
        User userToUpdate = (User) userDao.getById(2);
        // change the trip name
        userToUpdate.setUsername(userName);
        // save the changes
        userDao.saveOrUpdate(userToUpdate);
        // retrieve the same trip
        User retrievedUser = (User) userDao.getById(2);
        // verify changes were made
        assertEquals(userToUpdate, retrievedUser);
    }


    /**
     * Verify insert user successfully runs
     */
    @Test
    void insertUserSuccess() {
        // create a new user (use the constructor to set all values)
        User newUser = new User("NewUserName");
        // insert new user using dao
        int id = userDao.insert(newUser);
        assertNotEquals(0,id);
        // retrieve user
        User retrievedUser = (User) userDao.getById(id);
        // compare users using all fields of entity
        assertEquals(newUser, retrievedUser);
    }

    /**
     * Verify insert a user with a trip successfully runs
     */
    @Test
    void insertUserWithTripsSuccess() {
        // put trip on user and user on trip
        User newUser = new User("NewUserWithTrips");
        Trip newTrip = new Trip("2021 Road Tour", newUser);
        // nice to have method that does the set destinations
        newUser.addTrip(newTrip);

        // insert new user using dao
        int id = userDao.insert(newUser);
        // retrieve the inserted user
        User insertedUser = (User) userDao.getById(id);
        // compare users using all fields of entity
        assertTrue(newUser.equals(insertedUser));
    }
}