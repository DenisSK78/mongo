package com.example.mongo.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document
public class Employee {
    @Id
    private String id;
    private String name;
    private String profession;
    private Long date;

    public Employee(String id, String name, String profession) {
        this.id = id;
        this.name = name;
        this.profession = profession != null || profession.isEmpty() ? "profession" : profession;
        this.date = Instant.now().getEpochSecond();
    }

    public Employee() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

}
