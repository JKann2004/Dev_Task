package com.jkann.Final_Project.repository;

import com.jkann.Final_Project.entity.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends MongoRepository<Project, String> {
    List<Project> findByUserId(String userId);
    // Find by title
    Optional<Project> findByTitle(String title);
}
