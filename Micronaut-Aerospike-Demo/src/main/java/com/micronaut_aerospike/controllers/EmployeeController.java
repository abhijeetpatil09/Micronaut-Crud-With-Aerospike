package com.micronaut_aerospike.controllers;

import com.micronaut_aerospike.entities.EmailDetails;
import com.micronaut_aerospike.entities.Employee;
import com.micronaut_aerospike.services.EmailServices;
import com.micronaut_aerospike.services.EmployeeService;
import com.micronaut_aerospike.services.KafkaService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/employee")
public class EmployeeController {

    @Inject
    EmployeeService employeeService;
    @Inject
    KafkaService kafkaService;

    @Post(value = "/add")
    @Produces(MediaType.APPLICATION_JSON)
    public String addEmployee(@Body Employee employee) {
        EmailServices.sendEmail(new EmailDetails("Employee Alert !!!", "Congratulations "+employee.getName()+", Your Employee Id is "+employee.getId(), employee.getEmail()));
        kafkaService.insert(employee);
        return employeeService.addEmployee(employee);
    }
    @Get(value="/show")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }
    @Get(value = "/show/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee findById(@PathVariable int id){
        return  employeeService.findById(id);
    }
    @Delete(value = "/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteById(@PathVariable int id){
        kafkaService.delete(id);
        return  employeeService.deleteById(id);
    }
    @Put(value = "/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String update(Employee employee, @PathVariable int id){
        EmailServices.sendEmail(new EmailDetails("Alert!!", "Your Information is updated succeefully, " +
                "please check it is as follow. Your name is "+employee.getName()+
                ". This email id is your updated email id. Your currently working department is "
                +employee.getDepartment()+". And Your salary is "+employee.getSalary()+
                "rs. If any error in this information please let us know. Thank you.", employee.getEmail()));
        kafkaService.update(employee);
        return  employeeService.update(employee, id);
    }

}
