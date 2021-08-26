package com.example.mongo.data;

import com.example.mongo.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepositoryImpl repo;

    public EmployeeServiceImpl(EmployeeRepositoryImpl repo) {
        this.repo = repo;
    }

    @Override
    public List<Employee> findAll() {
        return repo.findAll();
    }

    @Override
    public void addEmployee(Employee employee) {
        repo.addEmployee(employee);
    }

    @Override
    public Employee findOne(String id) {
        return repo.findOne(id);
    }

    @Override
    public List<Employee> findWhereNameContains(String nameContains) {
        return repo.findWhereNameContains(nameContains);
    }
}
