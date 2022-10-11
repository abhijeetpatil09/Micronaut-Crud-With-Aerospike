package com.micronaut_aerospike.repositories;

import com.micronaut_aerospike.entities.Department;

import java.util.List;

public interface DepartmentRepository {

    public String addDepartment(Department department);

    public List<Department> getDepartments();

    public Department findById(int id);

    public String deleteById(int id);

    public String update(Department department, int id);
}
