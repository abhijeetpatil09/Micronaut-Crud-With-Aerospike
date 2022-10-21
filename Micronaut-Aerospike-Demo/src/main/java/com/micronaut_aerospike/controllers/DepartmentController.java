package com.micronaut_aerospike.controllers;

import com.micronaut_aerospike.entities.Department;
import com.micronaut_aerospike.services.DepartmentService;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;

import java.util.List;


@Controller("/department")
@Tag(name="Department Api")
@SecurityRequirement(name="Authorization")
@Secured(SecurityRule.IS_AUTHENTICATED)
public class DepartmentController {

    @Inject
    DepartmentService departmentService;

    @Post(value = "/add")
    @Produces(MediaType.APPLICATION_JSON)
    public String addDepartment(@Body Department department) {
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

        return  departmentService.deleteById(id);
    }

    @Put(value = "/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String update(Department department, @PathVariable int id){

        return  departmentService.update(department, id);
    }
}
