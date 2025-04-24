package com.epam.DepartmentService.service;


import com.epam.DepartmentService.entity.Department;
import com.epam.DepartmentService.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments()
    {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.getReferenceById(id);
    }

    public Department save(Department department)
    {
        departmentRepository.save(department);
        return department;
    }
}
