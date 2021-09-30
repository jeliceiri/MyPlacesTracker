package com.jilleliceiri.mptr.persistence;

import com.jilleliceiri.mptr.entity.Trip;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TripDao {

    // TODO add a table in the JSP for all trips and destinations - watch displaying to jsp video

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public List<Trip> getAll() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Trip> query = builder.createQuery( Trip.class );
        Root<Trip> root = query.from( Trip.class );
        List<Trip> trips = session.createQuery( query ).getResultList();

        logger.debug("The list of trips " + trips);
        session.close();

        return trips;
    }

    public int insertTrip(Trip newTrip) {
        int id = 0;
        logger.debug("Inserting: {}", newTrip);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(newTrip);
        transaction.commit();
        session.close();
        return id;
    }

    public Trip getById(int id) {
        logger.debug("Searching for getById {}", id);
        Session session = sessionFactory.openSession();
        Trip trip = session.get( Trip.class, id );
        session.close();
        return trip;
    }

    /**
     * update Trip
     * @param trip  Book to be inserted or updated
     */
    public void saveOrUpdate(Trip trip) {
        logger.debug("SaveOrUpdating: {}", trip);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(trip);
        transaction.commit();
        session.close();

    }
    /**
     * Delete a book
     * @param trip Trip to be deleted
     */
    // TODO write test for this
    public void delete(Trip trip) {
        logger.debug("Deleting: {}", trip);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(trip);
        transaction.commit();
        session.close();
    }
}
