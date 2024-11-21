package com.shubhi.academia.repo;

import com.shubhi.academia.entity.Employee;
import com.shubhi.academia.entity.Employee_salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeSalaryRepo extends JpaRepository<Employee_salary, Long> {
    public Employee_salary findByEmployeeAndPaymentMonth(Employee emp, String month);
}
