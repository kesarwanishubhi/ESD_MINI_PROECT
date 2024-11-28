package com.shubhi.academia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public record EmployeeDTO(
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("last_name")
        String LastName,
        @JsonProperty("email")
        String email,
        @JsonProperty("salary")
        int salary
) {
}
