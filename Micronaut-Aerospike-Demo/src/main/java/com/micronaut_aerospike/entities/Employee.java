package com.micronaut_aerospike.entities;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import com.aerospike.mapper.annotations.AerospikeReference;
import com.fasterxml.jackson.annotation.JsonFormat;


import java.util.Date;

@AerospikeRecord(namespace = "test",set = "Employee")
public class Employee {

    @AerospikeBin
    @AerospikeKey

    private int id;

    @AerospikeBin
    private String name;

    @AerospikeBin
    private String email;

    @AerospikeBin
    private double salary;

    @AerospikeBin
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date joiningDate;

    @AerospikeBin
    @AerospikeReference
    private Department department;

    public Employee() {
    }

    public Employee(String name, String email, double salary, Date joiningDate, Department department) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getJoiningDate() {
        return this.joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", joiningDate=" + joiningDate +
                ", department=" + department +
                '}';
    }
}
