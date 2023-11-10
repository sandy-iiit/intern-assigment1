package com.example.internassignment.services;

import com.example.internassignment.exceptions.DepartmentNotFoundException;
import com.example.internassignment.exceptions.EmployeeNotFoundException;
import com.example.internassignment.models.Department;
import com.example.internassignment.models.Employee;
import com.example.internassignment.repositories.DepartmentRepository;
import com.example.internassignment.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// EmployeeService.java
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        // Fetch department information using departmentId
        String departmentId = employee.getDepartmentId();
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new DepartmentNotFoundException(departmentId));

        // You can set the department details in the employee entity if needed
        // employee.setDepartment(department);

        return employee;
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee newEmployee) {
        Employee existingEmployee = getEmployeeById(id);

        existingEmployee.setFirstName(newEmployee.getFirstName());
        existingEmployee.setLastName(newEmployee.getLastName());
        existingEmployee.setEmail(newEmployee.getEmail());
        existingEmployee.setDepartmentId(newEmployee.getDepartmentId());

        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
