package com.jilleliceiri.mptr.controller;

import com.jilleliceiri.mptr.entity.Trip;
import com.jilleliceiri.mptr.entity.User;
import com.jilleliceiri.mptr.persistence.GenericDao;
import com.jilleliceiri.mptr.util.GenericValidator;
import com.jilleliceiri.mptr.util.ValidatorFactory;
import jakarta.validation.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A servlet to add a trip
 *
 * @author jeliceiri
 */
@WebServlet(
        urlPatterns = {"/addTrip"}
)

public class AddTrip extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericValidator genericValidator = new GenericValidator(Object.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = "/trips.jsp";
        GenericDao tripDao = new GenericDao(Trip.class);
        GenericDao userDao = new GenericDao(User.class);
        List<String> errors;
        int userId = Integer.parseInt(req.getParameter("userId"));
        try {
            User user = (User) userDao.getById(userId);
            Trip newTrip = new Trip(req.getParameter("addTrip"), user);
            Validator validator = ValidatorFactory.init();
            errors = genericValidator.validate(newTrip, validator);
            if (!errors.isEmpty()) {
                req.setAttribute("errMsg", errors);
                page = "/addTrip.jsp";
            } else {
                // insert the new trip and get the users trips
                tripDao.insert(newTrip);
                Set<Trip> tripSet = user.getTripSet();
                tripSet.add(newTrip);
                req.setAttribute("userId", userId);
                req.setAttribute("trips", tripSet);
                logger.debug("userId, trips: {} {}", userId, tripSet);
            }
        } catch (Exception e) {
            page = "/error.jsp";
            logger.error("Not able to insert new trip", e);
        } finally {
            RequestDispatcher dispatcher = req.getRequestDispatcher(page);
            dispatcher.forward(req, resp);
        }
    }
}
