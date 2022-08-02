package com.example.mongo;

import com.example.mongo.data.Employee;
import com.example.mongo.data.work.Direction;
import com.example.mongo.data.work.DocumentPropertiesService;
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

    final DocumentPropertiesService documentPropertiesService;

    public EmployeeController(EmployeeService service, DocumentPropertiesService documentPropertiesService) {
        this.service = service;
        this.documentPropertiesService = documentPropertiesService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getEmps(){
        List<Employee> all = service.findAll();
        all.forEach(System.out::println);
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/add")
    public void addEmp(){
        Employee emp = new Employee();
        emp.setName("Vala");
        documentPropertiesService.setDefaultDocumentProperties(emp, Direction.OUTCOME, "1898989898");
        service.addEmployee(emp);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getById(@PathVariable String id){
        Employee one = service.findOne(id);
        return new ResponseEntity<>(one, HttpStatus.OK);
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getWhereNameLike(@RequestParam String nameLike){
        return new ResponseEntity<>(service.findWhereNameContains(nameLike), HttpStatus.OK);
    }
}
