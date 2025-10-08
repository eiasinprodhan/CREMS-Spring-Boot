package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.Stage;
import com.eiasinprodhan.crems.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stages")
public class StageRestController {

    @Autowired
    private StageService stageService;

    @GetMapping("/")
    public ResponseEntity<List<Stage>> getAll() {
        List<Stage> stages = stageService.findAll();
        return ResponseEntity.ok(stages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stage> findById(@PathVariable Integer id) {
        Stage stage = stageService.findById(id);
        if (stage == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stage);
    }

    @PostMapping("/")
    public ResponseEntity<Stage> save(@RequestBody Stage stage) {
        Stage saved = stageService.save(stage);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/")
    public ResponseEntity<Stage> update(@RequestBody Stage stage) {
        Stage updated = stageService.save(stage);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        Stage existing = stageService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        stageService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<Stage>> findByFloor(@RequestParam Integer floor) {
        List<Stage> stages = stageService.findAllByFloor(floor);
        return ResponseEntity.ok(stages);
    }
}
