package com.jilleliceiri.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jilleliceiri.mptr.entity.Trip;
import com.jilleliceiri.mptr.persistence.GenericDao;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

@Path("/trips")
public class Rest {

    GenericDao tripDao = new GenericDao(Trip.class);

    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public Response getTrips() {
        List<Trip> trips = tripDao.getAll();
        String output = "";
        for(Trip trip : trips){
            output+=trip.getName()+"\n";
        }
        return Response.status(200).entity(output).build();
    }

    // The Java method will process HTTP GET requests
    @GET
    @Path("/{param}")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public Response getMessage(@PathParam("param") String id) {
        // Return a simple message
        int tripID = Integer.parseInt(id);
        Trip trip = (Trip)tripDao.getById(tripID);
        String output = trip.getName();
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response produceJSON() {
        // TODO create a OBJECT to JSON converter class
        List<Trip> trips = tripDao.getAll();
        return Response.status(200).entity(trips).build();
    }

    // Example from: https://crunchify.com/how-to-build-restful-service-with-java-using-jax-rs-and-jersey/
    @GET
    @Path("/json2")
    @Produces("application/json")
    public Response convertFtoC() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        Double fahrenheit = 98.24;
        Double celsius;
        celsius = (fahrenheit - 32) * 5 / 9;
        jsonObject.put("F Value", fahrenheit);
        jsonObject.put("C Value", celsius);

        String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
        return Response.status(200).entity(result).build();
    }

    /*
    @GET
    @Produces("text/html")
    public String getHtml() {
        return "<html><body><h1>Hello, World!!</body></h1></html>";
    }
    */

}
