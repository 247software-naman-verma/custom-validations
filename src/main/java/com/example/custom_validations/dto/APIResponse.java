package com.example.custom_validations.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class APIResponse<T> {
    private boolean success;
    private int statusCode;
    private String statusMessage;
    private T body;
}