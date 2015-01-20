package com.petzila.api.validation;

import com.petzila.api.model.XSignUpType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class XSignUpTypeValidator implements ConstraintValidator<ValidXSignUpType, XSignUpType> {
    @Override
    public void initialize(ValidXSignUpType constraintAnnotation) {

    }

    @Override
    public boolean isValid(XSignUpType value, ConstraintValidatorContext context) {
        return value != null;
    }
}
