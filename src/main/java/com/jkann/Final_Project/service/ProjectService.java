package com.jkann.Final_Project.service;

import com.jkann.Final_Project.entity.Project;
import com.jkann.Final_Project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    // Create Project
    public Project createProject(Project project) {
        project.setCreatedAt(new Date());
        return projectRepository.save(project);
    }

    // Get all projects
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // Delete project
    public void deleteProject(String id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
        }
    }

}
