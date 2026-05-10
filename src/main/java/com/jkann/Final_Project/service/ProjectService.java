package com.jkann.Final_Project.service;

import com.jkann.Final_Project.entity.Project;
import com.jkann.Final_Project.repository.ProjectRepository;
import com.jkann.Final_Project.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private TaskRepository taskRepository;

    // Create Project
    public Project createProject(Project project, String userId) {
        project.setCreatedAt(new Date());
        project.setUserId(userId);
        return projectRepository.save(project);
    }

    // Get all projects
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // Delete project
    public void deleteProject(String id, String userId) {
        Project project = projectRepository.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Project not found"
                ));
        projectRepository.delete(project);
    }

    // Update Project
    public Project updateProject(String id, Project request, String userId) {
        Project project = projectRepository.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Project not found"));

        project.setTitle(request.getTitle());
        project.setGenre(request.getGenre());
        project.setDescription(request.getDescription());

        return projectRepository.save(project);
    }

    public Project getProjectById(String id, String userId) {
        return projectRepository.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Project not found"
                ));
    }

}
