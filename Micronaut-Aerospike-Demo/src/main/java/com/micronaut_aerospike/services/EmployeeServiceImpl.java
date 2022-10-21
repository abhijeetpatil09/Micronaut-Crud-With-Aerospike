package com.micronaut_aerospike.services;
import com.micronaut_aerospike.entities.Employee;
import com.micronaut_aerospike.kafka.client.KafkaEmployee;
import com.micronaut_aerospike.repositories.EmployeeRepositoryImpl;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class EmployeeServiceImpl implements EmployeeService {

    @Inject
    EmployeeRepositoryImpl employeeRepository;
    @Inject
    EmailServices emailServices;

    @Inject
    KafkaEmployee kafkaEmployee;


    @Override
    public String addEmployee(Employee employee) {

        emailServices.sendMail(employee.getEmail(), "Congratulation "+employee.getName()+", your Employee Id is "+employee.getId(), "Employee Alert!!!!");
        kafkaEmployee.sendEmployeeNotification("Employee "+employee.getName()+" is added successfully.");
        return employeeRepository.addEmployee(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.getEmployees();
    }

    @Override
    public Employee findById(int id) {
        kafkaEmployee.sendEmployeeNotification("Employee found by Id: "+employeeRepository.findById(id));

        return employeeRepository.findById(id);
    }

    @Override
    public String deleteById(int id) {
        kafkaEmployee.sendEmployeeNotification("Employee deleted by Id: "+id);

        return employeeRepository.deleteById(id);
    }

    @Override
    public String update(Employee employee, int id) {
        emailServices.sendMail(employee.getEmail(), "Your Information is updated succeefully, " +
                "please check it is as follow. Your name is "+employee.getName()+
                ". This email id is your updated email id. Your currently working department is "
                +employee.getDepartment()+". And Your salary is "+employee.getSalary()+
                "rs. If any error in this information please let us know. Thank you.","Alert!!" );

        kafkaEmployee.sendEmployeeNotification("Employee Updated of Id: "+id+"  Updated details of employee : "+employee);

        return employeeRepository.update(employee, id);
    }

}
