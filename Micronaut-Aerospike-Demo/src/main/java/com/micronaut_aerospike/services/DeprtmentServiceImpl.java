package com.micronaut_aerospike.services;

import com.micronaut_aerospike.entities.Department;

import com.micronaut_aerospike.repositories.DepartmentRepositoryImpl;

import jakarta.inject.Inject;

import java.util.List;

public class DeprtmentServiceImpl implements DepartmentService{

    @Inject
    DepartmentRepositoryImpl departmentRepository;

    @Override
    public String addDepartment(Department department) {
        return departmentRepository.addDepartment(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.getDepartments();
    }

    @Override
    public Department findById(int id) {
        return departmentRepository.findById(id);
    }

    @Override
    public String deleteById(int id) {
        return departmentRepository.deleteById(id);
    }

    @Override
    public String update(Department department, int id) {
        return departmentRepository.update(department, id);
    }

}
