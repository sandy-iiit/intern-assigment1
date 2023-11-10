package com.example.internassignment.repositories;

import com.example.internassignment.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// EmployeeRepository.java
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
