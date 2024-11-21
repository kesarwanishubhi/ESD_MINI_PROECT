package com.shubhi.academia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
    @Table(name="Employee_salary")
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class Employee_salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "payment_month", nullable = false)
    private String paymentMonth;

//    @Column(name = "status", nullable = false)
//    private String status;
//
    @Column(name = "amount", nullable = false)
    private long amount;

//    @ManyToOne
//    @JoinColumn(name = "paid_by",nullable=false)
//    private Employee emp;

    @Column(name = "payment_date", nullable = false)
    private String paymentDate;



}
