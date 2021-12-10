package com.jilleliceiri.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jilleliceiri.mptr.entity.Trip;
import com.jilleliceiri.mptr.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * The type Rest service.
 * A weekly class exercise for Enterprise Java Class.
 */
@Path("/trips")
public class RestService {

    /**
     * The Trip dao.
     */
    GenericDao tripDao = new GenericDao(Trip.class);
    private ObjectMapper objectMapper = new ObjectMapper();
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * This endpoint returns all of the trips in plain text format.
     *
     * @return the trips
     */
    @GET
    @Produces("text/plain")
    public Response getTrips() {
        List<Trip> trips = tripDao.getAll();
        String output = "";
        for(Trip trip : trips){
            output+=trip.getName()+"\n";
        }
        return Response.status(200).entity(output).build();
    }

    /**
     * This endpoint returns a particular trip by id in plain text format
     *
     * @param id the id
     * @return the response
     */
    @GET
    @Path("/{param}")
    @Produces("text/plain")
    public Response getMessage(@PathParam("param") String id) {
        int tripID = Integer.parseInt(id);
        Trip trip = (Trip)tripDao.getById(tripID);
        String output = trip.getName();
        return Response.status(200).entity(output).build();
    }

    /**
     * This endpoint returns all of the trips in JSON format.
     *
     * @return the response
     */
    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response produceJSON() {
        List<Trip> trips = tripDao.getAll();
        String responseJSON = null;
        try {
            responseJSON = objectMapper.writeValueAsString(trips);
        } catch (JsonProcessingException e) {
            logger.error("json processing exception", e);
        }

        return Response.status(200).entity(responseJSON).build();
    }

    /**
     * Convert fto c response.
     *
     * @return the response
     * @throws JSONException the json exception
     */
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
}
