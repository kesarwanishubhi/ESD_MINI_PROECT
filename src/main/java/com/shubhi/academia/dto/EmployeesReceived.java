package com.shubhi.academia.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesReceived {
    @JsonProperty("employee_list")
    private List<EmployeeSalaryRequest> employeesReceived;
}