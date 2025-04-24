package com.epam.EmployeeService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEvent {
    private Long employeeId; // The ID of the employee
    private String employeeName; // The name of the employee
    private String employeeEmail; // The email of the employee
    private String action; // The type of action (e.g., CREATED, UPDATED, DELETED)
}
