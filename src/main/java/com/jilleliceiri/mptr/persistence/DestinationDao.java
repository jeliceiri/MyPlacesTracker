package com.jilleliceiri.mptr.persistence;

import com.jilleliceiri.mptr.entity.Destination;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DestinationDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public List<Destination> getAll() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Destination> query = builder.createQuery( Destination.class );
        Root<Destination> root = query.from( Destination.class );
        List<Destination> Destinations = session.createQuery( query ).getResultList();

        logger.debug("The list of Destinations " + Destinations);
        session.close();

        return Destinations;
    }

    public int insertDestination(Destination newDestination) {
        int id = 0;
        logger.debug("Inserting: {}", newDestination);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(newDestination);
        transaction.commit();
        session.close();
        return id;
    }
}
