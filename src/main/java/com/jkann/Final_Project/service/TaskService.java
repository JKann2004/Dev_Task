package com.jkann.Final_Project.service;

import com.jkann.Final_Project.entity.Task;
import com.jkann.Final_Project.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        task.setCreatedAt(new Date());
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteTask(String id, String projectId) {
        Task task = taskRepository.findByIdAndProjectId(id, projectId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Task not found"));

        taskRepository.delete(task);
    }

    public Task updateTask(String id, Task request, String projectId) {
        Task task = taskRepository.findByIdAndProjectId(id, projectId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Task not found"));

        task.setName(request.getName());
        task.setDescription(request.getDescription());
        task.setCategory(request.getCategory());
        task.setStatus(request.getStatus());

        return taskRepository.save(task);
    }

    public Task getTaskById(String id, String projectId) {
        return taskRepository.findByIdAndProjectId(id, projectId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Task not found"
                ));
    }
}
