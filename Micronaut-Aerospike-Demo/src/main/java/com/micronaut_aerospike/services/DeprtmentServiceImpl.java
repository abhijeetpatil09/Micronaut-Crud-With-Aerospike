package com.micronaut_aerospike.services;

import com.micronaut_aerospike.entities.Department;

import com.micronaut_aerospike.kafka.client.KafkaDepartment;
import com.micronaut_aerospike.repositories.DepartmentRepositoryImpl;

import jakarta.inject.Inject;

import java.util.List;

public class DeprtmentServiceImpl implements DepartmentService{

    @Inject
    DepartmentRepositoryImpl departmentRepository;
    @Inject
    KafkaDepartment kafkaDepartment;

    @Override
    public String addDepartment(Department department) {
        kafkaDepartment.sendDepartmentNotification("Department "+department.getDeptName()+" is added successfully.");
        return departmentRepository.addDepartment(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.getDepartments();
    }

    @Override
    public Department findById(int id) {
        kafkaDepartment.sendDepartmentNotification("Department found by Id : "+id);
        return departmentRepository.findById(id);
    }

    @Override
    public String deleteById(int id) {
        kafkaDepartment.sendDepartmentNotification("Department deleted by Id : "+id);

        return departmentRepository.deleteById(id);
    }

    @Override
    public String update(Department department, int id) {
        kafkaDepartment.sendDepartmentNotification("Department updated by Id : "+id+"  Updated details : "+department);

        return departmentRepository.update(department, id);
    }

}
