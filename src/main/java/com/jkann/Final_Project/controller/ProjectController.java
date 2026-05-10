package com.jkann.Final_Project.controller;

import com.jkann.Final_Project.entity.Project;
import com.jkann.Final_Project.service.ProjectService;
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
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Project getProject(@PathVariable String userId, @PathVariable String id) {
        return projectService.getProjectById(id, userId);
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable String userId, @PathVariable String id) {
        projectService.deleteProject(id, userId);
    }

    @PutMapping("/{id}")
    public Project updateProject(
            @PathVariable String userId,
            @PathVariable String id,
            @RequestBody Project request
    ) {
        return projectService.updateProject(id, request, userId);
    }
}
