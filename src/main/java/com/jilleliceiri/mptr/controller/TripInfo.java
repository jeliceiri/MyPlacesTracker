package com.jilleliceiri.mptr.controller;

import com.jilleliceiri.mptr.entity.Trip;
import com.jilleliceiri.mptr.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A servlet to add a trip
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/tripInfo"}
)

public class TripInfo extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        GenericDao genericDao = new GenericDao(Trip.class);
        //Trip newTrip = tripDao.getById(req.getParameter("tripID"));
        int id = (Integer.parseInt(req.getParameter("tripID")));
        //Trip getTrip = tripDao.getById(Integer.parseInt(req.getParameter("tripID")));
        logger.debug("Getting Trip ID: {}", id);
        System.out.println(id);
        // get destination set and send it?
        req.setAttribute("tripInfo", genericDao.getById(id));
        // TODO get destination set and setAttribute on request so that the tripInfo can iterate over the destinations
        // TODO will need to finish destination entity and dao/generic dao

        RequestDispatcher dispatcher = req.getRequestDispatcher("/tripInfo.jsp");
        dispatcher.forward(req, resp);
    }


}
