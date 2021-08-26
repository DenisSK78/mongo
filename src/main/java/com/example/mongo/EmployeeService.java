package com.example.mongo;

import com.example.mongo.data.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    void addEmployee(Employee employee);
    Employee findOne(String id);
    List<Employee> findWhereNameContains(String nameContains);
}
