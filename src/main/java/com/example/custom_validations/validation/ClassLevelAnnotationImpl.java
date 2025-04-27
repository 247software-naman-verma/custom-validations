package com.example.custom_validations.validation;

import com.example.custom_validations.dto.Post;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ClassLevelAnnotationImpl implements ConstraintValidator<ClassLevelAnnotation, Post> {
    @Override
    public void initialize(ClassLevelAnnotation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Post post, ConstraintValidatorContext context) {
        if(
            (post.getPostName()==null || post.getPostName().isEmpty() || post.getPostName().isBlank()) ||
            (post.getDescription()==null || post.getDescription().isEmpty() || post.getDescription().isBlank()) ||
            (post.getTags()==null || post.getTags().isEmpty())
        ){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Post object should have non-empty postName, description, and at least one tag with length greater than 0").addConstraintViolation();
            return false;
        }
        return true;
    }
}
