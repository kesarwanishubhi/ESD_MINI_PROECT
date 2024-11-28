package com.shubhi.academia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeSalaryUpdate {
    @JsonProperty("email")
    String email;
    @JsonProperty("salary")
    int salary;
}
