package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Departments {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long departmentId;

    @OneToMany(mappedBy= "departments",
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    public Set<Employees> employees;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public Set<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employees> employees) {
        this.employees = employees;
    }





}
