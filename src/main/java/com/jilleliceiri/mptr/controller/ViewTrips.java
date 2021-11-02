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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A servlet to retrieve all trips to view
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/viewTrips"}
)

public class ViewTrips extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        GenericDao tripDao = new GenericDao(Trip.class);
        GenericDao userDao = new GenericDao(User.class);

        // get username and id of logged in user
        // ISNT EASIER JUST TO DO A WHERE CLAUSE WITH Hibernate Query Language?
        String userName = req.getParameter("userName");
        System.out.println(userName);
        int userId = 0;

        List<User> allUsers = new ArrayList<>(userDao.getAll());
        for (User user : allUsers){
            if (user.getUsername().equals(userName)){
                userId = user.getId();
                System.out.println("userID:" + userId);
            }
        }

        // get all trips
        List<Trip> allTrips = new ArrayList<>(tripDao.getAll());
        // pull trips with that id
        List<Trip> userIdTrips = new ArrayList<>();
        for (Trip trip : allTrips){
            int id = trip.getUser().getId();
            System.out.println(id);
            if (id == userId){
                userIdTrips.add(trip);
            }
        }
        //req.setAttribute("userId", userId);
        req.setAttribute("trips", userIdTrips);
        session.setAttribute("userId", userId);
        session.setAttribute("userName", userName);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/trips.jsp");
        dispatcher.forward(req, resp);
    }
}
