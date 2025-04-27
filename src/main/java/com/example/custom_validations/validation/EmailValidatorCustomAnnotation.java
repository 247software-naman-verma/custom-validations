package com.example.custom_validations.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = EmailValidatorCustomAnnotationImpl.class)
    public @interface EmailValidatorCustomAnnotation {
        String message() default "Invalid email format";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};

    }
