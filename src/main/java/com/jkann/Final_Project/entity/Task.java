package com.jkann.Final_Project.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "tasks")
@Data
public class Task {
    @Id
    private String id;
    @Indexed
    private String name;
    private String description;
    @Indexed
    private String category;
    @Indexed
    private String Status;
    private String projectId;
    private Date createdAt;
}
