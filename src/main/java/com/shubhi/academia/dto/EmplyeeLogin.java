package com.shubhi.academia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public record EmplyeeLogin (

            @NotNull(message="Customer email is required")
            @Email(message = "Email must be in correct format")
            @JsonProperty("email")
            String email,

            @NotNull(message = "Password should be present")
            @NotEmpty(message = "Password should be present")
            @NotBlank(message = "Password should be present")

            @JsonProperty("password")
            String password
    ) {

    }


