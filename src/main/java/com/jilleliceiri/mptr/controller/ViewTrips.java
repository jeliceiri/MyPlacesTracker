package com.jilleliceiri.mptr.controller;

import com.jilleliceiri.mptr.entity.Trip;
import com.jilleliceiri.mptr.entity.User;
import com.jilleliceiri.mptr.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A servlet to retrieve all of the user's trips to view
 *
 * @author pwaite
 */
@WebServlet(
        urlPatterns = {"/viewTrips"}
)

public class ViewTrips extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        GenericDao tripDao = new GenericDao(Trip.class);
        GenericDao userDao = new GenericDao(User.class);
        int userId = 0;
        Set<Trip> tripSet;
        String page = "/trips.jsp";

        // get the userName and id
        String userName = req.getParameter("userName");
        try {
            List<User> allUsers = new ArrayList<>(userDao.getAll());
            for (User user : allUsers) {
                if (user.getUsername().equals(userName)) {
                    userId = user.getId();
                }
            }
            // get the User object and the User's trips
            User user = (User) userDao.getById(userId);
            tripSet = user.getTripSet();
            req.setAttribute("trips", tripSet);
            session.setAttribute("userId", userId);
            session.setAttribute("userName", userName);
        } catch (Exception e) {
            // route to error page
            page = "error.jsp";
            logger.error("Error retrieving user and/or trips", e);
        } finally {
            RequestDispatcher dispatcher = req.getRequestDispatcher(page);
            dispatcher.forward(req, resp);
        }
    }
}
