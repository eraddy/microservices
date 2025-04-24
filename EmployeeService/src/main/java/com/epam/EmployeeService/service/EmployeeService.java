package com.epam.EmployeeService.service;

import com.epam.EmployeeService.client.DepartmentFeignClient;
import com.epam.EmployeeService.dto.EmployeeDTO;
import com.epam.EmployeeService.dto.EmployeeEvent;
import com.epam.EmployeeService.dto.EmployeeWithDepartment;
import com.epam.EmployeeService.entity.Employee;
import com.epam.EmployeeService.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.epam.EmployeeService.dto.Department;


import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentFeignClient departmentFeignClient;

    @Autowired
    private EmployeeEvenPublisher employeeEvenPublisher;

    // Create a new employee
    public Employee saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhone(employeeDTO.getPhone());
        employee.setDepartmentId(employeeDTO.getDepartmentId());
        EmployeeEvent employeeEvent = new EmployeeEvent(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                "CREATED"
        );
        employeeEvenPublisher.sendEmployeeEvent(employeeEvent);
        return employeeRepository.save(employee);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get employee by ID
    public Employee getEmployeeById(Long id) {
        return employeeRepository.getReferenceById(id);
    }

    // Update an existing employee
    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.getReferenceById(id);
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhone(employeeDTO.getPhone());
        employee.setDepartmentId(employeeDTO.getDepartmentId());
        return employeeRepository.save(employee);
    }

    // Delete employee by ID
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeWithDepartment getEmployeeWithDepartment(Long id)
    {
        Employee employee = employeeRepository.getReferenceById(id);
        Department department = departmentFeignClient.getDepartmentById(id);
        return new EmployeeWithDepartment(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getPhone(),
                department.getId(),
                department.getName(),
                department.getDescription()
        );
    }
}
