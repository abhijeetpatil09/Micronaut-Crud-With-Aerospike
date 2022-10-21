package com.micronaut_aerospike.repositories;

import com.micronaut_aerospike.entities.Employee;
import java.util.List;

public interface EmployeeRepository  {


    String addEmployee(Employee employee);

    List<Employee> getEmployees();

    Employee findById(int id);

    String deleteById(int id);

    String update(Employee employee, int id);
}
