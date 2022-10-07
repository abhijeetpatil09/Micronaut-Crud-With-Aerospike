package com.micronaut_aerospike.repositories;

import com.micronaut_aerospike.configuration.AeroMapperConfiguration;

import com.micronaut_aerospike.entities.Employee;
import jakarta.inject.Inject;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository{

    @Inject
    AeroMapperConfiguration mapper;


    @Override
    public String addEmployee(Employee employee) {

        mapper.getMapper().save(employee);

        return "Employee created successfully id is "+employee.getId();
    }

    @Override
    public List<Employee> getEmployees() {
        return mapper.getMapper().scan(Employee.class);
    }

    @Override
    public Employee findById(int id) {
        return mapper.getMapper().read(Employee.class, id);
    }

    @Override
    public String deleteById(int id) {
        mapper.getMapper().delete(Employee.class, id);
        return "Employee deleted successfully";
    }

    @Override
    public String update(Employee employee, int id) {
        Employee emp = mapper.getMapper().read(Employee.class, id);
        emp.setId(employee.getId());
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        emp.setSalary(employee.getSalary());
        emp.setDepartment(employee.getDepartment());
        mapper.getMapper().save(emp);

        return "Employee Updated successfully";
    }


}
