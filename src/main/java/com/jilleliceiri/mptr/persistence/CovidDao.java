package com.jilleliceiri.mptr.persistence;

import com.covidactnow.CovidResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartystreets.SmartyResponseItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Properties;

/**
 * The type CovidDao dao.
 */
public class CovidDao {

    private Properties properties;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Instantiates a new CovidDao dao.
     */
    public CovidDao() {
        loadProperties();
    }

    private void loadProperties() {
        properties = new Properties();
        try {
            properties.load (this.getClass().getResourceAsStream("/restful.properties"));
        } catch (IOException ioe) {
            logger.error("CovidDao.loadProperties()...Cannot load the properties file");
        } catch (Exception e) {
            logger.error("SCovidDao.loadProperties()..." + e);
        }
    }


    public CovidResponse getResponse(String fips){
        Client client = ClientBuilder.newClient();
        String apikey = properties.getProperty("apikey");
        String url = "https://api.covidactnow.org/v2/county/" + fips + ".json?" + "apiKey=" + apikey;
        WebTarget target = client.target(url);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        CovidResponse covidResponse = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            covidResponse = mapper.readValue(response, CovidResponse.class);

        } catch (JsonProcessingException e) {
            logger.error("JsonProcessingException" + e);
        }
        return covidResponse ;
    }
}