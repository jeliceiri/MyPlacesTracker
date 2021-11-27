package com.jilleliceiri.mptr.persistence;

import com.covidactnow.CovidResponse;
import com.smartystreets.SmartyResponseItem;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The type Covid dao test.
 */
public class CovidDaoTest {
    
    /**
     * Verifies the CovidDao getResponse() successfully runs with city of Waunakee
     *
     * @throws Exception the exception
     */
    @Test
    void getLocalHospitalCapacityResponseWaunakee() throws Exception {
        String localHealthCapacityRatio = getLocalHealthCapacityResponse("55025"); // FIPS - Waunakee
        assertNotNull(localHealthCapacityRatio);
    }
    /**
     * Verifies the CovidDao getResponse() successfully runs with city of Aspen
     *
     * @throws Exception the exception
     */
    @Test
    void getLocalHospitalCapacityResponseAspen() throws Exception {
        String localHealthCapacityRatio = getLocalHealthCapacityResponse("08097"); //Aspen (N/A)
        assertNotNull(localHealthCapacityRatio);
    }

    /**
     * Verifies the CovidDao getResponse() successfully runs with city of Munising
     *
     * @throws Exception the exception
     */
    @Test
    void getLocalHospitalCapacityResponseMunising() throws Exception {
        String localHealthCapacityRatio = getLocalHealthCapacityResponse("26003");//Munising (null)
        assertNotNull(localHealthCapacityRatio);
    }

    /**
     * Verifies the CovidDao getResponse() successfully runs with City of Negaunee
     *
     * @throws Exception the exception
     */
    @Test
    void getLocalHospitalCapacityResponseNegaunee() throws Exception {
        String localHealthCapacityRatio = getLocalHealthCapacityResponse("26103");//Negaunee
        assertNotNull(localHealthCapacityRatio);
    }

    public String getLocalHealthCapacityResponse (String fips) {
        CovidDao dao = new CovidDao();
        CovidResponse localHealthInfo = dao.getResponse(fips);// FIPS - Waunakee: 55025 Aspen (N/A): 08097 Munising (null): 26003
        Double icuCapacityRatio = localHealthInfo.getMetrics().getIcuCapacityRatio();
        String percentage;
        if (icuCapacityRatio == null || icuCapacityRatio == 0){
            percentage = "N/A";
        } else {
            NumberFormat format = NumberFormat.getPercentInstance(Locale.US);
            percentage = format.format(icuCapacityRatio);
        }
        return percentage;
    }
}
