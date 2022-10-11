package com.micronaut_aerospike.repositories;

import com.micronaut_aerospike.entities.Employee;
import java.util.List;

public interface EmployeeRepository  {

    public String addEmployee(Employee employee);

    public List<Employee> getEmployees();

    public Employee findById(int id);

    public String deleteById(int id);

    public String update(Employee employee, int id);
}
