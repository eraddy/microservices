package com.epam.EmployeeService.client;

import com.epam.EmployeeService.dto.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentFeignClient {

    @GetMapping("/api/departments/{id}")
    Department getDepartmentById(@PathVariable Long id);
}
