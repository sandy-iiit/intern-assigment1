package com.example.internassignment.exceptions;

// EmployeeNotFoundException.java
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long employeeId) {
        super("Employee not found with id: " + employeeId);
    }
}

