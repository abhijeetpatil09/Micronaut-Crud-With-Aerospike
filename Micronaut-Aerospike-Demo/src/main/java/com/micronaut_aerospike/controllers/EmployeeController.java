package com.micronaut_aerospike.controllers;

import com.micronaut_aerospike.aop.MethodTracker;
import com.micronaut_aerospike.entities.Employee;
import com.micronaut_aerospike.services.EmployeeService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
@Controller("/employee")
@Tag(name="Employee Api")
@SecurityRequirement(name="Authorization")
@Secured(SecurityRule.IS_AUTHENTICATED)
public class EmployeeController {

    private static final Logger LOGGER= LogManager.getLogger(EmployeeController.class);

    @Inject
    EmployeeService employeeService;

    @Post(value = "/add")
    @Produces(MediaType.APPLICATION_JSON)
    @MethodTracker
    public String addEmployee(@Body Employee employee) {
        LOGGER.info("Employee "+employee.getName()+" has been added");
        return employeeService.addEmployee(employee);
    }
    @Get(value="/show")
    @Produces(MediaType.APPLICATION_JSON)
    @MethodTracker
    public List<Employee> getEmployees(){

        return employeeService.getEmployees();
    }
    @Get(value = "/show/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @MethodTracker
    public Employee findById(@PathVariable int id){
        LOGGER.info("Employee found by id: "+id);
        return  employeeService.findById(id);
    }
    @Delete(value = "/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @MethodTracker
    public String deleteById(@PathVariable int id){
        LOGGER.info("Employee deleted by id: "+id);
        return  employeeService.deleteById(id);
    }
    @Put(value = "/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @MethodTracker
    public String update(Employee employee, @PathVariable int id){
        LOGGER.info("Employee updated by id: "+id+"  Updated details : "+employee);
        return  employeeService.update(employee, id);
    }

}
