package com.shubhi.academia.controller;
//import com.shubhi.academia.dto.CustomerRequest;
//import com.shubhi.academia.dto.CustomerResponse;
import com.shubhi.academia.dto.EmployeeSalaryRequest;
import com.shubhi.academia.dto.EmployeesReceived;
import com.shubhi.academia.dto.EmplyeeLogin;
import com.shubhi.academia.service.EmployeeService;
import com.shubhi.academia.dto.EmplyeeLogin;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
//
//    @PostMapping("/create")
//    public ResponseEntity<?> createCustomer(@RequestBody @Valid CustomerRequest req){
//        return ResponseEntity.ok(customerService.creating(req));
//    }
//    @GetMapping("/{email}")
//    public ResponseEntity<?> getCustomer(
//            @RequestHeader("Authorization") String token,
//            @PathVariable("email") String email){
//        if(token == null) return ResponseEntity.status(401).build();
//        CustomerResponse response = customerService.retrieveCustomer(email, token);
//        if(response == null) return ResponseEntity.status(401).build();
//        return ResponseEntity.ok(response);
//    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid EmplyeeLogin req){
        return ResponseEntity.ok(employeeService.loginchecking(req));

    }

    @PostMapping("/employee")
    public ResponseEntity<?> disburseSalary(@RequestBody EmployeesReceived req) {
        return ResponseEntity.ok(employeeService.disburseSalary(req));
    }

}

