package com.epam.EmployeeService.repository;


import com.epam.EmployeeService.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // JpaRepository already provides methods like save(), findById(), findAll(), etc.
}