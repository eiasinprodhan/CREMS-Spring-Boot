package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.Project;
import com.eiasinprodhan.crems.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectRestController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/")
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.findAll();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Integer id) {
        Project project = projectService.findById(id);
        if (project != null) {
            return ResponseEntity.ok(project);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project created = projectService.save(project);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/")
    public ResponseEntity<Project> updateProject(@RequestBody Project project) {
        Project updated = projectService.save(project);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Integer id) {
        Project project = projectService.findById(id);
        if (project != null) {
            projectService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Project>> findProjectByProjectManager(@RequestParam Integer projectManager) {
        List<Project> projects = projectService.findByProjectManager(projectManager);
        return ResponseEntity.ok(projects);
    }
}
