package com.jilleliceiri.mptr.util;

import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class ValidatorFactory {

    private static Validator validator;


    public static Validator init() {
        jakarta.validation.ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        return validator;
    }

}
