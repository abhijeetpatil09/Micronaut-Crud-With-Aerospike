package com.services;

import com.micronaut_aerospike.entities.Employee;
import com.micronaut_aerospike.repositories.EmployeeRepositoryImpl;
import com.micronaut_aerospike.services.EmployeeService;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@MicronautTest
public class EmployeeServiceTest {
    @Inject
    EmployeeRepositoryImpl employeeRepository;

    @Inject
    EmployeeService employeeService;

    @MockBean
            (EmployeeRepositoryImpl.class)
    EmployeeRepositoryImpl employeeRepository() {

        return mock(EmployeeRepositoryImpl.class);
    };
    @Test
    void getEmployees() {

        when(employeeRepository.getEmployees()).thenReturn(Stream.of(new Employee(),
                new Employee(),
                new Employee()).collect(Collectors.toList()));

        Assertions.assertEquals(3,employeeService.getEmployees().size());
    }

   @Test
    void addEmployee(){
       Employee employee = new Employee(1, "Abhijeet", "abhi@gmail.com", 56324, "Java");

       when(employeeRepository.addEmployee(employee)).thenReturn("Employee created successfully");

       String result = employeeService.addEmployee(employee);

       assertEquals(result, "Employee created successfully");

   }
   @Test
    void findById(){
       Employee employee = new Employee(1, "Abhijeet", "abhi@gmail.com", 56324, "Java");

       when(employeeRepository.findById(1)).thenReturn(employee);

       Employee result = employeeService.findById(1);

       assertEquals(result, employeeService.findById(employee.getId()));
   }
   @Test
    void deleteById(){
       Employee employee = new Employee(1, "Abhijeet", "abhi@gmail.com", 56324, "Java");

       when(employeeRepository.deleteById(1)).thenReturn("Employee deleted successfully");

       String result = employeeService.deleteById(1);

       assertEquals(result, "Employee deleted successfully");
   }
   @Test
    void update(){
       Employee employee = new Employee(1, "Abhijeet", "abhi@gmail.com", 56324, "Java");

       Employee newEmp = new Employee(1, "Abhijeet", "abhi@gmail.com", 56324, "Aerospike");

       when(employeeRepository.update(employee,1)).thenReturn("Employee updated successfully");

       String result = employeeService.update(employee, 1);

       assertEquals(result, "Employee updated successfully" );
   }
}
