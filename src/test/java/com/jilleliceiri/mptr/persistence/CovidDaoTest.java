package com.jilleliceiri.mptr.persistence;

import com.covidactnow.CovidResponse;
import com.smartystreets.SmartyResponseItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CovidDaoTest {

    /**
     * Verifies the CovidDao getResponse() successfully runs
     */
    @Test
    void getLocalHospitalCapacityResponse() {
        CovidDao dao = new CovidDao();
        CovidResponse hospitalCapacity = dao.getResponse("55025");// Waunakee fips
        Double icuCapacityRatio = hospitalCapacity.getMetrics().getIcuCapacityRatio();
        assertNotNull(icuCapacityRatio);
    }
}
