package com.example.custom_validations.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IndianPhoneNumberValidatonImpl implements ConstraintValidator<IndianPhoneNumberValidation, String> {
    @Override
    public void initialize(IndianPhoneNumberValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null || value.isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Phone number not provided");
            return false;
        }
        String countryCode = value.substring(0,3);
        String phoneNumber = value.substring(3);
        if(countryCode.equals("+91") && phoneNumber.matches("\\d{10}")) {
            return true;
        }else{
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Invalid Indian phone number").addConstraintViolation();
            return false;
        }
    }
}
