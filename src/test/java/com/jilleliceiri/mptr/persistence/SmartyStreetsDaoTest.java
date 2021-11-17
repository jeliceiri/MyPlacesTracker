package com.jilleliceiri.mptr.persistence;
import com.smartystreets.SmartyResponse;
import com.smartystreets.SmartyResponseItem;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Smarty streets dao test.
 */
class SmartyStreetsDaoTest {

    /**
     * Verifies the getCityResponseSuccess() successfully runs
     *
     * @throws Exception the exception
     */
    @Test
    void getCityResponseSuccess()  throws Exception {
        SmartyStreetsDao dao = new SmartyStreetsDao();
        SmartyResponseItem[] city = dao.getCityResponse("Green Bay", "WI");
        String fips = "55009";
        String zipCode = "54229";
        // Green Bay zip code 54229 FIPS 55009
        // Marquette zip code 49855 FIPS 26103
        String retrievedFips = city[0].getZipcodes().get(0).getCountyFips();
        String retrievedZip = city[0].getZipcodes().get(0).getZipcode();

        assertEquals(fips, retrievedFips);
        assertEquals(zipCode, retrievedZip);
    }
}