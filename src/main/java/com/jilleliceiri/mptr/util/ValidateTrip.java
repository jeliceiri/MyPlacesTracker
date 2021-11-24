package com.jilleliceiri.mptr.util;

import com.jilleliceiri.mptr.entity.Trip;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
//Inspired from: https://zetcode.com/java/hibernatevalidator/

public class ValidateTrip {

    public static  List<String> validate(Trip trip) {

        List<String> errors = new ArrayList();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Trip>> cvs = validator.validate(trip);

        if (!cvs.isEmpty()) {

            for (ConstraintViolation<Trip> cv : cvs) {

                StringBuilder err = new StringBuilder();
                err.append(cv.getPropertyPath());
                err.append(": ");
                err.append(cv.getMessage());
                errors.add(err.toString());
            }
        }
        return errors;
    }
}