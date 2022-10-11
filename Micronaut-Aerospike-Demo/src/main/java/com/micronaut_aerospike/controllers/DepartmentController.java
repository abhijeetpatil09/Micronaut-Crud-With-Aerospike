package com.micronaut_aerospike.controllers;

import com.micronaut_aerospike.entities.Department;
import com.micronaut_aerospike.services.DepartmentService;

import com.micronaut_aerospike.services.KafkaService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import java.util.List;


@Controller("/department")
public class DepartmentController {

    @Inject
    DepartmentService departmentService;
//    @Inject
//    KafkaService kafkaService;

    @Post(value = "/add")
    @Produces(MediaType.APPLICATION_JSON)
    public String addDepartment(@Body Department department) {
        //kafkaService.insert(department);
        return departmentService.addDepartment(department);
    }
    @Get(value="/show")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

    @Get(value = "/show/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Department findById(@PathVariable int id){
        return  departmentService.findById(id);
    }

    @Delete(value = "/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteById(@PathVariable int id){
       // kafkaService.delete(id);
        return  departmentService.deleteById(id);
    }

    @Put(value = "/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String update(Department department, @PathVariable int id){

      //  kafkaService.update(employee);
        return  departmentService.update(department, id);
    }
}
