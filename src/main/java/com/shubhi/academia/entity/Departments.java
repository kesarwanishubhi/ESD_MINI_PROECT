package com.shubhi.academia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Departments")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long department_id;

    @Column(name = "name", nullable = false)
    private String departmentName;

    @Column(name = "capacity", nullable = false)
    private int capacity;
}
