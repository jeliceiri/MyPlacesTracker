package com.jilleliceiri.mptr.controller;

import com.jilleliceiri.mptr.util.PropertiesLoaderInterface;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;


/**
 * This is a servlet performs initialization
 *
 * @author jeliceiri
 */
@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/startup" },
        loadOnStartup = 1
)
public class Startup extends HttpServlet implements PropertiesLoaderInterface {

    Properties properties;
    public static String CLIENT_ID;
    public static String LOGIN_URL;
    public static String REDIRECT_URL;
    public static String CLIENT_SECRET;
    public static String OAUTH_URL;
    public static String REGION;
    public static String POOL_ID;


    /**
     * Load cognito properties file and store its information in ServletContext
     */
    public void init () {

        ServletContext context = getServletContext();

        properties = loadProperties("/cognito.properties");
        CLIENT_ID = properties.getProperty("client.id");
        LOGIN_URL = properties.getProperty("loginURL");
        REDIRECT_URL = properties.getProperty("redirectURL");
        CLIENT_SECRET = properties.getProperty("client.secret");
        OAUTH_URL = properties.getProperty("oauthURL");
        REGION = properties.getProperty("region");
        POOL_ID = properties.getProperty("poolId");

        context.setAttribute("CLIENT_ID", CLIENT_ID);
        context.setAttribute("LOGIN_URL", LOGIN_URL);
        context.setAttribute("REDIRECT_URL", REDIRECT_URL);
        context.setAttribute("CLIENT_SECRET", CLIENT_SECRET);
        context.setAttribute("OAUTH_URL", OAUTH_URL);
        context.setAttribute("REGION", REGION);
        context.setAttribute("POOL_ID", POOL_ID);
    }
}
