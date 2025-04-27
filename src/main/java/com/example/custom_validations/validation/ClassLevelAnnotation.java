package com.example.custom_validations.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ClassLevelAnnotationImpl.class)
public @interface ClassLevelAnnotation {

    String message() default "Post data is invalid";  // Default error message

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
