package com.example.custom_validations.exceptions;

import com.example.custom_validations.dto.APIResponse;
import com.example.custom_validations.dto.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<APIResponse<ErrorDetails>> handleInvalidEmailException(InvalidEmailException ex) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setField("email");
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setExplanation("The provided email address format is invalid.");

        APIResponse<ErrorDetails> apiResponse = APIResponse.<ErrorDetails>builder()
                .statusMessage("Validation failed")
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .success(false)
                .body(errorDetails)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse<List<ErrorDetails>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<ErrorDetails> errorDetailsList = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String message = error.getDefaultMessage();
            ErrorDetails errorDetails = new ErrorDetails();
            if (error instanceof FieldError fieldError) {
                errorDetails.setField(fieldError.getField().replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase());
            } else {
                errorDetails.setField(error.getObjectName());
            }
            errorDetails.setMessage(message);
            errorDetails.setExplanation("Field acceptance criteria failed");
            errorDetailsList.add(errorDetails);
        });

        APIResponse<List<ErrorDetails>> apiResponse = APIResponse.<List<ErrorDetails>>builder()
                .statusMessage("Number is not valid Indian phone number")
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .success(false)
                .body(errorDetailsList)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }


}
