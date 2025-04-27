package com.example.custom_validations.controller;

import com.example.custom_validations.dto.APIResponse;
import com.example.custom_validations.dto.UserDetails;
import com.example.custom_validations.validation.EmailValidatorCustomAnnotation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validations")
public class EmailValidationController {

    @PostMapping("/validate-email")
    public APIResponse<String> validateEmail(@RequestParam @EmailValidatorCustomAnnotation String email) {
        return APIResponse.<String>builder()
                .statusMessage("Validation Successful")
                .statusCode(HttpStatus.OK.value())
                .success(true)
                .body("Email is Valid, You can proceed ahead")
                .build();
    }

    @PostMapping("/validate-phone-number")
    public APIResponse<String> validateUserNumber(@RequestBody @Valid UserDetails userDetails) {
        return APIResponse.<String>builder()
                .statusMessage("Validation Successful")
                .statusCode(HttpStatus.OK.value())
                .success(true)
                .body("User is Valid, You can proceed ahead")
                .build();
    }

}
