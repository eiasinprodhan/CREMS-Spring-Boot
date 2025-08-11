package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.Project;
import com.eiasinprodhan.crems.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/projects/")
public class ProjectRestController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("")
    public List<Project> findAll(){
        return projectService.findAll();
    }

    @PostMapping("save")
    public ResponseEntity<Map<String, String>> save(
            @RequestBody Project project
    ){
        try {
            projectService.save(project);
            Map<String, String> response = new HashMap<>();
            response.put("Message", "Project added successfully.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            Map<String, String> response = new HashMap<>();
            response.put("Message", "Project adding unsuccessfully.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("update")
    public ResponseEntity<Map<String, String>> update(Project project){
        try {
            projectService.save(project);
            Map<String, String> response = new HashMap<>();
            response.put("Message", "Project updated successfully.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            Map<String, String> response = new HashMap<>();
            response.put("Message", "Project update unsuccessfully.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete")
    public ResponseEntity<Map<String, String>> delete(@RequestBody Project project){
        try {
            projectService.deleteById(project.getId());
            Map<String, String> response = new HashMap<>();
            response.put("Message", "Project deleted successfully.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            Map<String, String> response = new HashMap<>();
            response.put("Message", "Project delete unsuccessfully.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
