package com.epam.EmployeeService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;          // Primary Key
    private String name;      // Employee Name
    private String email;     // Employee Email
    private String phone;     // Employee Phone Number
    private Long departmentId; // Foreign Key to link to a department (via the Department Service)

}