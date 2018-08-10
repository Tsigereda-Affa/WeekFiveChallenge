package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface DepartmentsRepository extends CrudRepository<Departments, Long> {

    ArrayList<Departments> findByName(String department);
}
