package com.shubhi.academia.service;

import com.shubhi.academia.dto.*;
import com.shubhi.academia.entity.Departments;
import com.shubhi.academia.entity.Employee;
import com.shubhi.academia.entity.Employee_salary;
import com.shubhi.academia.helper.JWThelper;
import com.shubhi.academia.repo.EmployeeRepo;
//import com.shubhi.academia.repo.EmployeeSalaryRepo;
import com.shubhi.academia.repo.EmployeeSalaryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepo rep;
    private final EmployeeSalaryRepo repo;

    private final JWThelper jwThelper;


    public String loginchecking(EmplyeeLogin req) {
        Employee employee = rep.findByEmail(req.email());
        if (employee != null && employee.getPassword() != null && employee.getPassword().equals(req.password())) {
            String token = jwThelper.generateToken(employee.getEmail(),employee.getDepartment().getDepartmentName());
//            System.out.println(token);
            return token;
        } else {
            return "fail";
        }
    }

    public String disburseSingle(EmployeeSalaryRequest recv){

        Employee employee = rep.findByEmail(recv.getEmail());
        Employee_salary emp=repo.findByEmployeeAndPaymentMonth(employee, recv.getMonth());
        if(emp != null){
            return "fail";
        }

        repo.save(Employee_salary.builder()
                     .employee(employee)
                     .amount(employee.getSalary())
                     .paymentMonth(recv.getMonth())
                     .paymentDate(String.valueOf(new Date()))
             .build());
        return "successfully paid for this employee";
    }

    public List<String> disburseSalary(EmployeesReceived req,String email) {
        List<String> paid=new ArrayList<>();
        for(EmployeeSalaryRequest emp: req.getEmployeesReceived()) {
            if(emp.getEmail().equals(email)){continue;}
            paid.add(disburseSingle(emp));
        }
        return paid;
    }
    public String headerChecking(String recievedToken){
        String token = recievedToken.substring(7); // Extract token from "Bearer {token}"

        return jwThelper.validateToken(token) && jwThelper.extractRole(token).equals("Accounts") ?
                jwThelper.extractUsername(token) : null;
    }
    public String modifyDetails(EmployeeSalaryUpdate req, String email){
        Employee emp = rep.findByEmail(req.getEmail());
        if(emp.getEmail().equals(email)){
            return "Not Allowed";
        }
        emp.setSalary(req.getSalary());
        rep.save(emp);
        return "successfully modified salary";
    }
    public List<EmployeeDTO> displayDetails(String email){
        List<Employee> employees=rep.findAll();
        List<EmployeeDTO> dtos=new ArrayList<>();
        for(Employee emp: employees){
            if(emp.getEmail().equals(email)){
                continue;
            }
            dtos.add(new EmployeeDTO(emp.getFirstName(), emp.getLastName(), emp.getEmail(), emp.getSalary()));
        }

        return dtos;
    }
}

