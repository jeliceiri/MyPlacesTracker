package com.jilleliceiri.mptr.persistence;
import com.smartystreets.SmartyResponse;
import com.smartystreets.SmartyResponseItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Smarty streets dao test.
 */
class SmartyStreetsDaoTest {

    /**
     * Verifies the getCityResponseSuccess() successfully runs
     */
    @Test
    void getCityResponseSuccess() {
        SmartyStreetsDao dao = new SmartyStreetsDao();
        SmartyResponseItem[] city = dao.getCityResponse("Chicago", "Il");
        String fips = "17031"; // Chicago fips
        //String fips = "55025"; // Waunakee fips
        String retrievedFips = city[0].getZipcodes().get(0).getCountyFips();
        assertEquals(fips, retrievedFips);
    }
}