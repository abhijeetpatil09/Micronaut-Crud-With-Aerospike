package com.micronaut_aerospike.services;

import com.micronaut_aerospike.entities.Department;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public interface DepartmentService {

    String addDepartment(Department department);

    List<Department> getDepartments();

    Department findById(int id);

    String deleteById(int id);

    String update(Department department, int id);
}
