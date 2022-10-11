package com.controller;

import com.micronaut_aerospike.controllers.DepartmentController;
import com.micronaut_aerospike.entities.Department;
import com.micronaut_aerospike.services.DeprtmentServiceImpl;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@MicronautTest
public class DepartmentControllerTest {
    @Inject
    DepartmentController departmentController;

    @Inject
    DeprtmentServiceImpl deprtmentService;

    @MockBean
            (DeprtmentServiceImpl.class)
    DeprtmentServiceImpl deprtmentService() {

        return mock(DeprtmentServiceImpl.class);
    };
    @Test
    void getDepartments() {

        when(deprtmentService.getDepartments()).thenReturn(Stream.of(new Department(),
                new Department(),
                new Department()).collect(Collectors.toList()));

        Assertions.assertEquals(3,departmentController.getDepartments().size());
    }

    @Test
    void addDepartment(){
        Department department = new Department(1, "Java");
        when(deprtmentService.addDepartment(department)).thenReturn("Department created successfully");

        String result = departmentController.addDepartment(department);

        assertEquals(result, "Department created successfully");

    }
    @Test
    void findById(){
        Department department = new Department(1, "Java");
        department.setDeptId(1);
        when(deprtmentService.findById(department.getDeptId())).thenReturn(department);

        Department result = departmentController.findById(1);

        assertEquals(result, departmentController.findById(department.getDeptId()));
    }
    @Test
    void deleteById(){
        Department department = new Department(1, "Java");
        department.setDeptId(1);
        when(deprtmentService.deleteById(department.getDeptId())).thenReturn("Department deleted successfully");

        String result = departmentController.deleteById(1);

        assertEquals(result, "Department deleted successfully");
    }
    @Test
    void update(){

        Department department = new Department("Java");
        department.setDeptId(1);
        Department newDept = new Department("Aerospike");


        when(deprtmentService.update(department,1)).thenReturn("Department updated successfully");

        String result = departmentController.update(department, 1);

        assertEquals(result, "Department updated successfully" );
    }
}
