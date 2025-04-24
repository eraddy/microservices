package com.epam.DepartmentService.controller;


import com.epam.DepartmentService.dto.DepartmentDTO;
import com.epam.DepartmentService.entity.Department;
import com.epam.DepartmentService.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments()
    {
        List<Department> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    @PostMapping
    public Department saveDepartment(@RequestBody Department department)
    {
        log.info("the data from the postman {}",department);
        return departmentService.save(department);
    }

    // Endpoint to fetch department by ID
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable("id") Long id) {
        Department department = departmentService.getDepartmentById(id);
        DepartmentDTO departmentDTO = new DepartmentDTO(department.getId(),department.getName(),department.getDescription());
        return ResponseEntity.ok(departmentDTO);
    }
}
