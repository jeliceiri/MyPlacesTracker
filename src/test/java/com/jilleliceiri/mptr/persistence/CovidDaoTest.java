package com.jilleliceiri.mptr.persistence;

import com.covidactnow.CovidResponse;
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
     * Verifies the getLocalIcuCapacity() successfully runs with city of Waunakee
     *
     * @throws Exception the exception
     */
    @Test
    void getLocalHospitalCapacityResponseWaunakee() throws Exception {
        String localIcuCapacity = getLocalIcuCapacity("55025"); // FIPS - Waunakee
        assertNotNull(localIcuCapacity);
    }

    /**
     * Verifies the getLocalIcuCapacity() successfully runs with city of Aspen
     *
     * @throws Exception the exception
     */
    @Test
    void getLocalHospitalCapacityResponseAspen() throws Exception {
        String localIcuCapacity = getLocalIcuCapacity("08097"); //Aspen (N/A)
        assertNotNull(localIcuCapacity);
    }

    /**
     * Verifies the getLocalIcuCapacity() successfully runs with city of Munising
     *
     * @throws Exception the exception
     */
    @Test
    void getLocalHospitalCapacityResponseMunising() throws Exception {
        String localIcuCapacity = getLocalIcuCapacity("26003");//Munising (null)
        assertNotNull(localIcuCapacity);
    }

    /**
     * Verifies the getLocalIcuCapacity() successfully runs with city of Negaunee
     *
     * @throws Exception the exception
     */
    @Test
    void getLocalHospitalCapacityResponseNegaunee() throws Exception {
        String localIcuCapacity = getLocalIcuCapacity("26103");//Negaunee
        assertNotNull(localIcuCapacity);
    }

    /**
     * Verifies the getLocalRiskLevel() successfully runs with city of Negaunee
     *
     * @throws Exception the exception
     */
    @Test
    void getRiskLevelNegaunee() throws Exception {
        String riskLevel = getLocalRiskLevel("26103");//Negaunee
        assertNotNull(riskLevel);
        System.out.println(riskLevel);
    }

    /**
     * Verifies the getLocalRiskLevel() successfully runs with city of allendale co.
     *
     * @throws Exception the exception
     */
    @Test
    void getRiskLevelAllendaleCo() throws Exception {
        String riskLevel = getLocalRiskLevel("45005");// Allendale County, SC FIPS 45005
        assertNotNull(riskLevel);
    }
    /**
     * Gets local risk level from the CovidDao getResponse()
     *
     * @param fips the county fips code
     * @return the risk level
     */
    private String getLocalRiskLevel(String fips) {
        CovidDao dao = new CovidDao();
        String risk;
        CovidResponse covidResponse = dao.getResponse(fips);
        int riskInt = covidResponse.getRiskLevels().getOverall();
        if (riskInt == 0) {
            risk = "low";
        } else if (riskInt == 1) {
            risk = "medium";
        } else if (riskInt == 2) {
            risk = "high";
        } else if (riskInt == 3) {
            risk = "very high";
        } else if (riskInt == 4) {
            risk = "severe";
        } else risk = "N/A";
        return risk;
    }

    /**
     * Gets local health icu capacity ratio from the CovidDao getResponse()
     *
     * @param fips the county fips code
     * @return the percent occupied of icu
     */
    public String getLocalIcuCapacity(String fips) {
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
