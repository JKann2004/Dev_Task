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
    public List<Project> getAllProjects(String userId) {
        return projectRepository.findByUserId(userId);
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

        if (request.getTitle() != null) {
            project.setTitle(request.getTitle());
        }
        if (request.getGenre() != null) {
            project.setGenre(request.getGenre());
        }
        if (request.getDescription() != null) {
            project.setDescription(request.getDescription());
        }
        return projectRepository.save(project);
    }

    public Project getProjectById(String id, String userId) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Project not found"
                ));
        if (!project.getUserId().equals(userId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Not your project");
        }
        return project;
    }

}
