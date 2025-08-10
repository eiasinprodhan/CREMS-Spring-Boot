package com.spring.crems.restcontroller;

import com.spring.crems.entity.Project;
import com.spring.crems.repository.IProjectRepo;
import com.spring.crems.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects/")
public class ProjectRestController {

    @Autowired
    private IProjectRepo projectRepo;

    @Autowired
    private ProjectService projectService;

    @GetMapping("")
    public ResponseEntity<List<Project>> findAll() {
        try {
            List<Project> projects = projectRepo.findAll();
            return ResponseEntity.ok(projects);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody Project project) {
        try {
            projectService.saveOrUpdate(project);
            return ResponseEntity.status(HttpStatus.CREATED).body("Project saved");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Project not saved");
        }
    }
}
