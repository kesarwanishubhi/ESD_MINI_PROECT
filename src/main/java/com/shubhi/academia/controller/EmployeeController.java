package com.shubhi.academia.controller;
//import com.shubhi.academia.dto.CustomerRequest;
//import com.shubhi.academia.dto.CustomerResponse;
import com.shubhi.academia.dto.*;
import com.shubhi.academia.helper.JWThelper;
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
    private final JWThelper jwThelper;
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
    @PutMapping("/modify")
    public ResponseEntity<?> modify(@RequestBody EmployeeSalaryUpdate req,@RequestHeader("Authorization") String bearerToken){
        if(bearerToken==null)return ResponseEntity.status(401).build();
        String email= employeeService.headerChecking(bearerToken);
        if(email == null) return ResponseEntity.status(401).build();

        return  ResponseEntity.ok(employeeService.modifyDetails(req, email));
    }
    @GetMapping("/display")
    public ResponseEntity<?> display(@RequestHeader("Authorization") String bearerToken){
        if(bearerToken==null)return ResponseEntity.status(401).build();
        String email= employeeService.headerChecking(bearerToken);
        if(email==null)return ResponseEntity.status(401).build();

        return  ResponseEntity.ok(employeeService.displayDetails(email));

    }

    @PostMapping("/employee")
    public ResponseEntity<?> disburseSalary(@RequestBody EmployeesReceived req,@RequestHeader("Authorization") String bearerToken)
    {

        if(bearerToken==null)return ResponseEntity.status(401).build();
        String email= employeeService.headerChecking(bearerToken);
        if(email==null)return ResponseEntity.status(401).build();

        return ResponseEntity.ok(employeeService.disburseSalary(req,email));
    }

}

