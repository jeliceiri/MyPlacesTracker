package com.jilleliceiri.mptr.controller;

import com.jilleliceiri.mptr.persistence.TripDao;

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
        urlPatterns = {"/addTrip"}
)

public class AddTrip extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String newTripName = req.getParameter("newTripName");

        TripDao tripDao = new TripDao();

        //req.setAttribute("trips", tripDao.getAll());


        if (newTripName != null){
            req.setAttribute("trips", tripDao.insertTrip(newTripName));
        } req.setAttribute("trips", tripDao.getAll());




        RequestDispatcher dispatcher = req.getRequestDispatcher("/main.jsp");
        dispatcher.forward(req, resp);
    }
}
