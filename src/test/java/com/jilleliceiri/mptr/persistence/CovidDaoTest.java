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
     * Verifies the CovidDao getResponse() successfully runs
     *
     * @throws Exception the exception
     */
    @Test
    void getLocalHospitalCapacityResponse() throws Exception {
        CovidDao dao = new CovidDao();
        CovidResponse localHealthInfo = dao.getResponse("55025");// FIPS - Waunakee: 55025 Aspen (N/A): 08097 Munising (null): 26003
        Double icuCapacityRatio = localHealthInfo.getMetrics().getIcuCapacityRatio();
        String percentage;
        if (icuCapacityRatio == null || icuCapacityRatio == 0){
            percentage = "N/A";
        } else {
            NumberFormat format = NumberFormat.getPercentInstance(Locale.US);
            percentage = format.format(icuCapacityRatio);
        }
        assertNotNull(icuCapacityRatio);
    }
}
