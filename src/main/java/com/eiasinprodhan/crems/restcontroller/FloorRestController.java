package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.Floor;
import com.eiasinprodhan.crems.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/floors")
public class FloorRestController {

    @Autowired
    private FloorService floorService;

    @GetMapping("/")
    public ResponseEntity<List<Floor>> findAll() {
        List<Floor> floors = floorService.findAll();
        return ResponseEntity.ok(floors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Floor> findById(@PathVariable int id) {
        Floor floor = floorService.findById(id);
        if (floor != null) {
            return ResponseEntity.ok(floor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Floor> save(@RequestBody Floor floor) {
        Floor savedFloor = floorService.save(floor);
        return ResponseEntity.ok(savedFloor);
    }

    @PutMapping("/")
    public ResponseEntity<Floor> update(@RequestBody Floor floor) {
        Floor updatedFloor = floorService.save(floor);
        return ResponseEntity.ok(updatedFloor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Floor floor = floorService.findById(id);
        if (floor != null) {
            floorService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Floor>> findAllByBuilding(@RequestParam int building) {
        List<Floor> floors = floorService.findAllByBuilding(building);
        return ResponseEntity.ok(floors);
    }
}
