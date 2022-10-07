package com.micronaut_aerospike.services;
import com.micronaut_aerospike.entities.Employee;
import com.micronaut_aerospike.repositories.EmployeeRepositoryImpl;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class EmployeeServiceImpl implements EmployeeService {

    @Inject
    EmployeeRepositoryImpl employeeRepository;

    @Override
    public String addEmployee(Employee employee) {
        return employeeRepository.addEmployee(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.getEmployees();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public String deleteById(int id) {
        return employeeRepository.deleteById(id);
    }

    @Override
    public String update(Employee employee, int id) {
        return employeeRepository.update(employee, id);
    }

}
