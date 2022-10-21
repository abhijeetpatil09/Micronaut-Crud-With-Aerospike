package com.micronaut_aerospike.services;

import com.micronaut_aerospike.entities.Employee;
import jakarta.inject.Singleton;
import java.util.List;

@Singleton
public interface EmployeeService {


    String addEmployee(Employee employee);

    List<Employee> getEmployees();

    Employee findById(int id);

    String deleteById(int id);

    String update(Employee employee, int id);
}
