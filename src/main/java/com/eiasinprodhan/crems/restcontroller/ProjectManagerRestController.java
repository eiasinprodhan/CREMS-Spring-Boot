package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.ProjectManager;
import com.eiasinprodhan.crems.service.ProjectManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/projectmanagers")
public class ProjectManagerRestController {

    @Autowired
    private ProjectManagerService projectManagerService;

    @GetMapping("/all")
    public List<ProjectManager> findAll() {
        return projectManagerService.findAll();
    }

    @GetMapping("/{id}")
    public ProjectManager findById(@PathVariable Integer id) {
        return projectManagerService.findById(id);
    }

    @PostMapping("/save")
    public void saveProject(@RequestBody ProjectManager projectManager) {
        projectManagerService.save(projectManager);
    }

    @PutMapping("/update")
    public ProjectManager update(@RequestBody ProjectManager projectManager) {
        return projectManagerService.update(projectManager);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        projectManagerService.delete(id);
    }
}
