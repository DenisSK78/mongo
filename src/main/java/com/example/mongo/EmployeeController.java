package com.example.mongo;

import com.example.mongo.data.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getEmps(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/add")
    public void addEmp(){
        Employee emp = new Employee();
        emp.setName("Vala");
        service.addEmployee(emp);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getById(@PathVariable String id){
        return new ResponseEntity<>(service.findOne(id), HttpStatus.OK);
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getWhereNameLike(@RequestParam String nameLike){
        return new ResponseEntity<>(service.findWhereNameContains(nameLike), HttpStatus.OK);
    }
}
