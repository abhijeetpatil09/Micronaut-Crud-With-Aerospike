package com.micronaut_aerospike.services;

import com.micronaut_aerospike.entities.Employee;
import jakarta.inject.Singleton;

import javax.validation.constraints.NotNull;
import java.util.List;

@Singleton
public interface EmployeeService {

    public String addEmployee(Employee employee);

    public List<Employee> getEmployees();

    public Employee findById(int id);

    public String deleteById(int id);

    public String update(Employee employee, int id);
}
