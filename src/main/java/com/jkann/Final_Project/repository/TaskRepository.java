package com.jkann.Final_Project.repository;

import com.jkann.Final_Project.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TaskRepository extends MongoRepository<Task, String> {
    Optional<Task> findBytitle(String title);
}
