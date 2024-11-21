package com.shubhi.academia.repo;
import com.shubhi.academia.entity.Departments;
import com.shubhi.academia.entity.Employee;
import com.shubhi.academia.entity.Employee_salary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    public Employee findByEmail(String email);
   //public Employee_salary findbyid(String email);
}
