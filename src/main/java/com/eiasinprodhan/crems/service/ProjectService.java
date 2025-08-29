package com.eiasinprodhan.crems.service;

import com.eiasinprodhan.crems.entity.Project;
import com.eiasinprodhan.crems.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private IProjectRepository projectRepository;

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findById(Integer id) {
        return projectRepository.findById(id).get();
    }

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public Project update(Project project) {
        return projectRepository.save(project);
    }

    public void deleteById(Integer id) {
        projectRepository.deleteById(id);
    }

    public List<Project> findByProjectManager(Integer projectManager) {
        return projectRepository.findProjectByProjectManager(projectManager);
    }

}
