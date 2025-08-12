package com.eiasinprodhan.crems.service;

import com.eiasinprodhan.crems.entity.ProjectManager;
import com.eiasinprodhan.crems.repository.IProjectManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectManagerService {

    @Autowired
    private IProjectManagerRepository projectManagerRepository;

    public List<ProjectManager> findAll() {
        return projectManagerRepository.findAll();
    }

    public ProjectManager findById(Integer id) {
        return projectManagerRepository.findById(id).get();
    }

    public void save(ProjectManager projectManager) {
         projectManagerRepository.save(projectManager);
    }

    public ProjectManager update(ProjectManager projectManager) {
        return projectManagerRepository.save(projectManager);
    }
    public void delete(Integer id) {
        projectManagerRepository.deleteById(id);
    }
}
