package com.micronaut_aerospike.services;

import com.micronaut_aerospike.entities.Department;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public interface DepartmentService {
    public String addDepartment(Department department);

    public List<Department> getDepartments();

    public Department findById(int id);

    public String deleteById(int id);

    public String update(Department department, int id);
}
