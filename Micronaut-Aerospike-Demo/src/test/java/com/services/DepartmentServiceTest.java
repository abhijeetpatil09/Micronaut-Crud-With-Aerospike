package com.services;

import com.micronaut_aerospike.entities.Department;
import com.micronaut_aerospike.repositories.DepartmentRepositoryImpl;
import com.micronaut_aerospike.services.DepartmentService;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
public class DepartmentServiceTest {

    @Inject
    DepartmentRepositoryImpl departmentRepository;

    @Inject
    DepartmentService departmentService;

    @MockBean
            (DepartmentRepositoryImpl.class)
    DepartmentRepositoryImpl departmentRepository() {

        return mock(DepartmentRepositoryImpl.class);
    };
    @Test
    void getDepartments() {

        when(departmentRepository.getDepartments()).thenReturn(Stream.of(new Department(),
                new Department(),
                new Department()).collect(Collectors.toList()));

        Assertions.assertEquals(3,departmentService.getDepartments().size());
    }

    @Test
    void addDepartment(){
        Department department = new Department(1, "Java");
        when(departmentRepository.addDepartment(department)).thenReturn("Department created successfully");

        String result = departmentService.addDepartment(department);

        assertEquals(result, "Department created successfully");

    }
    @Test
    void findById(){
        Department department = new Department(1, "Java");
        department.setDeptId(1);
        when(departmentRepository.findById(department.getDeptId())).thenReturn(department);

        Department result = departmentService.findById(1);

        assertEquals(result, departmentService.findById(department.getDeptId()));
    }
    @Test
    void deleteById(){
        Department department = new Department(1, "Java");
        department.setDeptId(1);
        when(departmentRepository.deleteById(department.getDeptId())).thenReturn("Department deleted successfully");

        String result = departmentService.deleteById(1);

        assertEquals(result, "Department deleted successfully");
    }
    @Test
    void update(){

        Department department = new Department("Java");
        department.setDeptId(1);
        Department newDept = new Department("Aerospike");


        when(departmentRepository.update(department,1)).thenReturn("Department updated successfully");

        String result = departmentService.update(department, 1);

        assertEquals(result, "Department updated successfully" );
    }
}
