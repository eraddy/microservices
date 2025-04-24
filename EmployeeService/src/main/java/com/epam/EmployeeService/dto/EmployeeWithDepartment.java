package com.epam.EmployeeService.dto;

import com.epam.EmployeeService.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeWithDepartment {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Long departmentId;

    private String departmentName;
    private String departmentDescription;
}
