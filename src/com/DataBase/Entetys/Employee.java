package com.DataBase.Entetys;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

    private String Id;

    @JsonProperty("Id")
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    private double salary;
    @JsonProperty("salary")
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    private String name;
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    private String department;
    @JsonProperty("department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    private String role;
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
