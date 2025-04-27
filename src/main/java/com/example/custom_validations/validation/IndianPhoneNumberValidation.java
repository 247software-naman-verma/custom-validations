package com.example.custom_validations.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IndianPhoneNumberValidatonImpl.class)
public @interface IndianPhoneNumberValidation {
    String message() default "Invalid Indian phone number format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
