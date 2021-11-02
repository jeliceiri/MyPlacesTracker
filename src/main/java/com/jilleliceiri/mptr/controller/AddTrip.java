package com.jilleliceiri.mptr.controller;

import com.jilleliceiri.mptr.entity.Trip;
import com.jilleliceiri.mptr.entity.User;
import com.jilleliceiri.mptr.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A servlet to add a trip
 *
 * @author jeliceiri
 */
@WebServlet(
        urlPatterns = {"/addTrip"}
)

public class AddTrip extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao tripDao = new GenericDao(Trip.class);
        GenericDao userDao = new GenericDao(User.class);
        int userId = Integer.parseInt(req.getParameter("userId"));
        User user = (User)userDao.getById(userId);
        Trip newTrip = new Trip(req.getParameter("addTrip"), user);

        int id = tripDao.insert(newTrip);



        // get all trips
        List<Trip> allTrips = new ArrayList<>(tripDao.getAll());
        // pull trips with that id
        List<Trip> userIdTrips = new ArrayList<>();
        for (Trip trip : allTrips){
            int uid = trip.getUser().getId();
            System.out.println(uid);
            if (uid == userId){
                userIdTrips.add(trip);
            }
        }
        req.setAttribute("userId", userId);
        req.setAttribute("trips", userIdTrips);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/trips.jsp");
        dispatcher.forward(req, resp);
    }
}
