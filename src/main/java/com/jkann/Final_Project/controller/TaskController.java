package com.jkann.Final_Project.controller;

import com.jkann.Final_Project.entity.Task;
import com.jkann.Final_Project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable String projectId, @PathVariable String id) {
        return taskService.getTaskById(id, projectId);

    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String projectId, @PathVariable String id) {
        taskService.deleteTask(id, projectId);
    }

    @PutMapping("/{id}")
    public Task updateTask(
            @PathVariable String projectId,
            @PathVariable String id,
            @RequestBody Task request
    ) {
        return taskService.updateTask(id, request, projectId);
    }
}
