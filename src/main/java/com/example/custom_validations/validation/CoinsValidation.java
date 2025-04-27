package com.example.custom_validations.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CoinsValidationImpl.class)
public @interface CoinsValidation {
    int coins() default 100;
    String message() default "Invalid coins value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
