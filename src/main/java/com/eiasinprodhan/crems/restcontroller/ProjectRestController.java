package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.Project;
import com.eiasinprodhan.crems.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/projects")
public class ProjectRestController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/")
    public List<Project> getAllProjects() {
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Integer id) {
        return projectService.findById(id);
    }

    @PostMapping("/")
    public Project createProject(@RequestBody Project project) {
        return projectService.save(project);
    }

    @PutMapping("/")
    public Project updateProject(@RequestBody Project project) {
        return projectService.save(project);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Integer id) {
        projectService.deleteById(id);
    }
}
