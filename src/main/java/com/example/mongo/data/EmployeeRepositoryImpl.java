package com.example.mongo.data;

import com.example.mongo.EmployeeRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final MongoTemplate template;

    public EmployeeRepositoryImpl(MongoTemplate template) {
        this.template = template;
    }


    public List<Employee> findAll() {
        return template.findAll(Employee.class);
    }

    public void addEmployee(Employee employee) {
        template.save(employee);
    }

    public Employee findOne(String id){
        return template.findOne(Query.query(Criteria.where("_id").is(id)),
                Employee.class, "employee");
    }

    public List<Employee> findWhereNameContains(String nameContains){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(nameContains));
        return template.find(query, Employee.class);
    }
}
