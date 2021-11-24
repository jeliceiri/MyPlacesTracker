package com.jilleliceiri.mptr.util;

import java.util.List;

import com.jilleliceiri.mptr.entity.Trip;
import com.jilleliceiri.mptr.entity.User;
import jakarta.validation.Validator;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidatorTest {

    GenericValidator genericTripValidator = new GenericValidator(Trip.class);
    GenericValidator genericUserValidator = new GenericValidator(User.class);


    @Test
    public void verifyTripNameIsNotEmpty() {

        User user = new User("jilltest");
        Trip newTrip = new Trip(null, user);
        Validator validator = ValidatorFactory.init();
        List<String> errors = genericTripValidator.validate(newTrip, validator);
        assertEquals("[name: must not be empty]", errors.toString());
    }

    @Test
    public void verifyUserNameIsNotEmpty() {
        User user = new User("");
        Validator validator = ValidatorFactory.init();
        List<String> errors = genericUserValidator.validate(user, validator);
        assertEquals("[username: must not be empty]", errors.toString());
    }
}
