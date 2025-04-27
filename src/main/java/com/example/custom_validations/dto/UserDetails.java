package com.example.custom_validations.dto;

import com.example.custom_validations.validation.CoinsValidation;
import com.example.custom_validations.validation.IndianPhoneNumberValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDetails {

    @JsonProperty("phone_number")
    @IndianPhoneNumberValidation
    private String phoneNumber;

    @CoinsValidation(coins = 100)
    private int coins;

}
