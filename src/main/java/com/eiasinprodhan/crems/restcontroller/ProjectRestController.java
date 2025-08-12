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

    @GetMapping("/all")
    public List<Project> findAll() {
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public Project findById(@PathVariable Integer id) {
        return projectService.findById(id);
    }

    @PostMapping("/save")
    public Project save(@RequestBody Project project) {
        return projectService.save(project);
    }

    @PutMapping("/update")
    public Project update(@RequestBody Project project) {
        return projectService.update(project);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        projectService.deleteById(id);
    }
}
