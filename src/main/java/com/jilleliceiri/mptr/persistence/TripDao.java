package com.jilleliceiri.mptr.persistence;

import com.jilleliceiri.mptr.entity.Trip;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TripDao {

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

    public int insertTrip(String newTripName) {


        return 0;


    }
}
