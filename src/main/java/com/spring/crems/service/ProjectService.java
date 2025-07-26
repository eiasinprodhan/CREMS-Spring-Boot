package com.spring.crems.service;

import com.spring.crems.entity.Project;
import com.spring.crems.repository.IProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private IProjectRepo projectRepo;

    public List<Project> findAll() {
        return projectRepo.findAll();
    }

    public Project findById(int id) {
        return projectRepo.findById(id).get();
    }

    public void saveOrUpdate(Project project) {
        projectRepo.save(project);
    }

    public void deleteById(int id) {
        projectRepo.deleteById(id);
    }

}
