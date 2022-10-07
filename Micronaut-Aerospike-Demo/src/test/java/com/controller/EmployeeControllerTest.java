package com.controller;

import com.micronaut_aerospike.controllers.EmployeeController;
import com.micronaut_aerospike.entities.Employee;
import com.micronaut_aerospike.services.EmployeeServiceImpl;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
class EmployeeControllerTest {
    @Inject
    EmployeeServiceImpl employeeService;

    @Inject
    EmployeeController employeeController;

    @MockBean
            (EmployeeServiceImpl.class)
    EmployeeServiceImpl employeeService() {

        return mock(EmployeeServiceImpl.class);
    };

    @Test
    void addEmployee() {
        Employee employee = new Employee(1, "Abhijeet", "abhi@gmail.com", 56324, "Java");

        when(employeeService.addEmployee(employee)).thenReturn("Employee created successfully");

        String result = employeeController.addEmployee(employee);

        assertEquals(result, "Employee created successfully");
    }

    @Test
    void getEmployees() {
        when(employeeService.getEmployees()).thenReturn(Stream.of(new Employee(),
                new Employee(),
                new Employee()).collect(Collectors.toList()));

        Assertions.assertEquals(3,employeeController.getEmployees().size());
    }

    @Test
    void findById() {
        Employee employee = new Employee(1, "Abhijeet", "abhi@gmail.com", 56324, "Java");

        when(employeeService.findById(1)).thenReturn(employee);

        Employee result = employeeController.findById(1);

        assertEquals(result, employeeController.findById(employee.getId()));
    }

    @Test
    void deleteById() {
        Employee employee = new Employee(1, "Abhijeet", "abhi@gmail.com", 56324, "Java");

        when(employeeService.deleteById(1)).thenReturn("Employee deleted successfully");

        String result = employeeController.deleteById(1);

        assertEquals(result, "Employee deleted successfully");
    }

    @Test
    void update() {
        Employee employee = new Employee(1, "Abhijeet", "abhi@gmail.com", 56324, "Java");

        Employee newEmp = new Employee(1, "Abhijeet", "abhi@gmail.com", 56324, "Aerospike");

        when(employeeService.update(employee,1)).thenReturn("Employee updated successfully");

        String result = employeeController.update(employee, 1);

        assertEquals(result, "Employee updated successfully" );
    }
}
