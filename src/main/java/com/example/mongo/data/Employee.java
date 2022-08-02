package com.example.mongo.data;

import com.example.mongo.data.work.DocumentProperties;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Random;

@Document
@ToString
public class Employee {
    @Id
    private String id;
    private String name = getRandomNumberUsingNextInt(100000, 999999);
    private String profession;

    private LocalDateTime createdDateTime;

    private Long createdUnix = Instant.now().getEpochSecond();

    private DocumentProperties documentProperties;

    public Employee(String id, String name, String profession) {
        this.id = id;
        this.profession = profession;
    }

    public String getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        int i = random.nextInt(max - min) + min;
        return String.valueOf(i);
    }

    public Employee() {
    }

    public DocumentProperties getDocumentProperties() {
        return documentProperties;
    }

    public void setDocumentProperties(DocumentProperties documentProperties) {
        this.documentProperties = documentProperties;
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

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Long getCreatedUnix() {
        return createdUnix;
    }

    public void setCreatedUnix(Long createdUnix) {
        this.createdUnix = createdUnix;
    }
}
