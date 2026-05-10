package com.jkann.Final_Project.controller;

import com.jkann.Final_Project.entity.Task;
import com.jkann.Final_Project.service.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project/{projectId}/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks(@PathVariable String projectId,
                                  HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        return taskService.getAllTasks(projectId, userId);
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable String projectId,
                        @PathVariable String id,
                        HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        return taskService.getTaskById(id, projectId, userId);
    }

    @PostMapping
    public Task createTask(@PathVariable String projectId,
                           @RequestBody Task task,
                           HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        return taskService.createTask(task, projectId, userId);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String projectId,
                           @PathVariable String id,
                           HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        taskService.deleteTask(id, projectId, userId);
    }

    @PutMapping("/{id}")
    public Task updateTask(
            @PathVariable String projectId,
            @PathVariable String id,
            @RequestBody Task task,
            HttpServletRequest request
    ) {
        String userId = (String) request.getAttribute("userId");
        return taskService.updateTask(id, task, projectId, userId);
    }
}
