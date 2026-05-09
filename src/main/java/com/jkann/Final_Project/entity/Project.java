package com.jkann.Final_Project.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "projects")
@Data
public class Project {
    @Id
    private String id;

    @Indexed
    private String title;

    @Indexed
    private String genre;

    private String userId;

    private String description;
    private Date createdAt;


}
