package com.jilleliceiri.mptr.controller;

import com.jilleliceiri.mptr.util.PropertiesLoaderInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Log in.
 */
@WebServlet(
        urlPatterns = {"/logIn"}
)

/** Begins the authentication process using AWS Cognito
 *
 */
public class LogIn extends HttpServlet implements PropertiesLoaderInterface {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void init() throws ServletException {
        super.init();
    }

    /**
     * Route to the aws-hosted cognito login page.
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get cognito information from servlet context
        ServletContext servCon = getServletContext();
        String redirect_url = (String)servCon.getAttribute("REDIRECT_URL");
        String client_id = (String)servCon.getAttribute("CLIENT_ID");
        String login_url = (String)servCon.getAttribute("LOGIN_URL");

        if (redirect_url==null || client_id==null || login_url==null){
            RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
            dispatcher.forward(req, resp);
        } else {
            String url = login_url + "?response_type=code&client_id=" + client_id + "&redirect_uri=" + redirect_url;
            resp.sendRedirect(url);
        }

    }
}
