package com.example.internassignment.exceptions;

// DepartmentNotFoundException.java
public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException(String departmentId) {
        super("Department not found with id: " + departmentId);
    }
}
