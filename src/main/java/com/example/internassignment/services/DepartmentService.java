package com.example.internassignment.services;

import com.example.internassignment.models.Department;
import com.example.internassignment.exceptions.DepartmentNotFoundException;
import com.example.internassignment.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// DepartmentService.java
@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(String id) {
        return departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException(id));
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(String id, Department newDepartment) {
        Department existingDepartment = getDepartmentById(id);

        existingDepartment.setDepartmentName(newDepartment.getDepartmentName());

        return departmentRepository.save(existingDepartment);
    }

    public void deleteDepartment(String id) {
        departmentRepository.deleteById(id);
    }
}

