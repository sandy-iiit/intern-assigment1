package com.example.internassignment.repositories;

import com.example.internassignment.models.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

// DepartmentRepository.java
public interface DepartmentRepository extends MongoRepository<Department, String> {
}
