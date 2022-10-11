package com.micronaut_aerospike.repositories;

import com.micronaut_aerospike.configuration.AeroMapperConfiguration;
import com.micronaut_aerospike.entities.Department;
import jakarta.inject.Inject;

import java.util.List;

public class DepartmentRepositoryImpl implements DepartmentRepository{

    @Inject
    AeroMapperConfiguration mapper;


    @Override
    public String addDepartment(Department department) {

        mapper.getMapper().save(department);

        return "Department created successfully id is "+department.getDeptId();
    }

    @Override
    public List<Department> getDepartments() {
        return mapper.getMapper().scan(Department.class);
    }

    @Override
    public Department findById(int id) {
        return mapper.getMapper().read(Department.class, id);
    }

    @Override
    public String deleteById(int id) {
        mapper.getMapper().delete(Department.class, id);
        return "Department deleted successfully";
    }

    @Override
    public String update(Department department, int id) {
        Department dept = mapper.getMapper().read(Department.class, id);
        dept.setDeptId(department.getDeptId());
        dept.setDeptName(department.getDeptName());

        mapper.getMapper().save(dept);

        return "Department Updated successfully";
    }

}
