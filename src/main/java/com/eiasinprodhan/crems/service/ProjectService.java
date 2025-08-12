package com.eiasinprodhan.crems.service;

import com.eiasinprodhan.crems.entity.Project;
import com.eiasinprodhan.crems.repository.IProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final IProjectRepository projectRepository;

    public ProjectService(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findById(Integer id) {
        return projectRepository.findById(id).orElse(null);
    }

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public Project update(Project project) {
        return projectRepository.save(project); // Same method as save in JPA
    }

    public void deleteById(Integer id) {
        projectRepository.deleteById(id);
    }
}
