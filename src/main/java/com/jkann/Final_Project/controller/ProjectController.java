package com.jkann.Final_Project.controller;

import com.jkann.Final_Project.entity.Project;
import com.jkann.Final_Project.service.ProjectService;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.validator.internal.constraintvalidators.bv.time.pastorpresent.PastOrPresentValidatorForJapaneseDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAllProjects(HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        return projectService.getAllProjects(userId);
    }

    @GetMapping("/{id}")
    public Project getProject(@PathVariable String id, HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        return projectService.getProjectById(id, userId);
    }

    @PostMapping
    public Project createProject(@RequestBody Project project, HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        return projectService.createProject(project, userId);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable String id, HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        projectService.deleteProject(id, userId);
    }

    @PutMapping("/{id}")
    public Project updateProject(
            @PathVariable String id,
            @RequestBody Project requestBody,
            HttpServletRequest request
    ) {
        String userId = (String) request.getAttribute("userId");
        return projectService.updateProject(id, requestBody, userId);
    }
}
