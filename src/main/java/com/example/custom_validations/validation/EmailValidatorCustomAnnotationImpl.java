package com.example.custom_validations.validation;

import com.example.custom_validations.exceptions.InvalidEmailException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.routines.EmailValidator;

@RequiredArgsConstructor
public class EmailValidatorCustomAnnotationImpl implements ConstraintValidator<EmailValidatorCustomAnnotation, String> {

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        boolean isValid = EmailValidator.getInstance().isValid(email);
        if(Boolean.FALSE.equals(isValid)){
            throw new InvalidEmailException("Invalid email format");
        }
        return true;
    }
}
