package com.example.custom_validations.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CoinsValidationImpl implements ConstraintValidator<CoinsValidation, Integer> {
    private int coins;
    @Override
    public void initialize(CoinsValidation constraintAnnotation) {
        this.coins = constraintAnnotation.coins();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if(value < coins) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Coins should be at least 100").addConstraintViolation();
            return false;
        }
        return true;
    }
}
