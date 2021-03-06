package com.jilleliceiri.mptr.util;

import java.util.List;

import com.jilleliceiri.mptr.entity.Destination;
import com.jilleliceiri.mptr.entity.Note;
import com.jilleliceiri.mptr.entity.Trip;
import com.jilleliceiri.mptr.entity.User;
import jakarta.validation.Validator;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Validator test.
 */
public class ValidatorTest {

    /**
     * The Generic validator.
     */
    GenericValidator genericValidator = new GenericValidator(Object.class);

    /**
     * Verify trip name field is not empty.
     */
    @Test
    public void verifyTripNameFieldIsNotEmpty() {

        User user = new User("jilltest");
        Trip newTrip = new Trip("", user);
        Validator validator = ValidatorFactory.init();
        List<String> errors = genericValidator.validate(newTrip, validator);
        assertEquals("[name: must not be empty]", errors.toString());
    }
    /**
     * Verify user name field is not empty.
     */
    @Test
    public void verifyUserNameFieldIsNotEmpty() {
        User user = new User("");
        Validator validator = ValidatorFactory.init();
        List<String> errors = genericValidator.validate(user, validator);
        assertEquals("[username: must not be empty]", errors.toString());
    }


    /**
     * Verify destination city field is not empty.
     */
    @Test
    public void verifyDestinationCityFieldIsNotEmpty() {
        User user = new User("jill-test");
        Trip trip = new Trip("new-trip-test", user);

        Destination destination = new Destination("", "WI", "", "", "", "", trip);
        Validator validator = ValidatorFactory.init();
        List<String> errors = genericValidator.validate(destination, validator);
        assertEquals("[city: must not be empty]", errors.toString());
    }

    /**
     * Verify destination state field is not empty.
     */
    @Test
    public void verifyDestinationStateFieldIsNotEmpty() {
        User user = new User("jill-test");
        Trip trip = new Trip("new-trip-test", user);

        Destination destination = new Destination("Waunakee", "", "", "", "", "", trip);
        Validator validator = ValidatorFactory.init();
        List<String> errors = genericValidator.validate(destination, validator);
        assertEquals(errors.size(), 2); // state must not be empty and state must be 2 digits
    }


    /**
     * Verify destination state field is two digits.
     */
    @Test
    public void verifyDestinationStateFieldIsTwoDigits() {
        User user = new User("jill-test");
        Trip trip = new Trip("new-trip-test", user);

        Destination destination = new Destination("Waunakee", "W", "", "", "", "", trip);
        Validator validator = ValidatorFactory.init();
        List<String> errors = genericValidator.validate(destination, validator);
        assertEquals("[state: must be two digits]", errors.toString());
    }

    /**
     * Verify note name field is not empty.
     */
    @Test
    public void verifyNoteNameFieldIsNotEmpty() {
        User user = new User("jill-test");
        Trip trip = new Trip("new-trip-test", user);

        Note note = new Note("", "description", trip);
        Validator validator = ValidatorFactory.init();
        List<String> errors = genericValidator.validate(note, validator);
        assertEquals("[name: must not be empty]", errors.toString());
    }

    /**
     * Verify note description field is not empty.
     */
    @Test
    public void verifyNoteDescriptionFieldIsNotEmpty() {
        User user = new User("jill-test");
        Trip trip = new Trip("new-trip-test", user);

        Note note = new Note("new-note-name", "", trip);
        Validator validator = ValidatorFactory.init();
        List<String> errors = genericValidator.validate(note, validator);
        assertEquals("[description: must not be empty]", errors.toString());
    }

}