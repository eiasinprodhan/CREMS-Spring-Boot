package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.Stage;
import com.eiasinprodhan.crems.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stages")
@CrossOrigin("*")
public class StageRestController {

    @Autowired
    private StageService stageService;

    @GetMapping("/")
    public List<Stage> getAll(){
        return stageService.findAll();
    }

    @GetMapping("/{id}")
    public Stage findById(@PathVariable Integer id){
        return stageService.findById(id);
    }

    @PostMapping("/")
    public Stage save(@RequestBody Stage stage){
        return stageService.save(stage);
    }

    @PutMapping("/")
    public Stage update(@RequestBody Stage stage){
        return stageService.save(stage);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        stageService.deleteById(id);
    }

    @GetMapping
    public List<Stage> findByFloor(@RequestParam Integer floor){
        return findByFloor(floor);
    }
}
