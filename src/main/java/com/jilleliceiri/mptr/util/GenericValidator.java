package com.jilleliceiri.mptr.util;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
//Inspired from: https://zetcode.com/java/hibernatevalidator/

public class GenericValidator<T> {


    private Class<T> type;

    public GenericValidator(Class<T> type) {
        this.type = type;
    }


    public List<String> validate(T entity, Validator validator) {

        List<String> errors = new ArrayList();

        Set<ConstraintViolation<T>> cvs = validator.validate(entity);

        if (!cvs.isEmpty()) {

            for (ConstraintViolation<T> cv : cvs) {

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