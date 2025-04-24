package com.epam.EmployeeService.controller;


import com.epam.EmployeeService.dto.EmployeeDTO;
import com.epam.EmployeeService.dto.EmployeeWithDepartment;
import com.epam.EmployeeService.entity.Employee;
import com.epam.EmployeeService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    // Create a new employee
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeService.saveEmployee(employeeDTO);
        return ResponseEntity.ok(employee);
    }

    // Get all employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        Employee employee =  employeeService.getEmployeeById(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setName(employee.getName());
        employeeDTO.setDepartmentId(employee.getDepartmentId());
        employeeDTO.setPhone(employee.getPhone());
        return ResponseEntity.ok(employeeDTO);
    }

    @GetMapping("/{id}/department")
    public ResponseEntity<EmployeeWithDepartment> getEmployeeWithDepartmentById(@PathVariable Long id) {
        EmployeeWithDepartment employee =  employeeService.getEmployeeWithDepartment(id);
        return ResponseEntity.ok(employee);
    }

    // Update employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employeeDTO));
    }

    // Delete employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
