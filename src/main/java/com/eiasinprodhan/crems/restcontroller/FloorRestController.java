package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.Floor;
import com.eiasinprodhan.crems.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/floors")
@CrossOrigin("*")
public class FloorRestController {

    @Autowired
    private FloorService floorService;

    @GetMapping("/")
    public List<Floor> findAll() {
        return floorService.findAll();
    }

    @GetMapping("/{id}")
    public Floor findById(@PathVariable int id) {
        return floorService.findById(id);
    }

    @PostMapping("/")
    public Floor save(@RequestBody Floor floor) {
        return floorService.save(floor);
    }

    @PutMapping("/")
    public Floor update(@RequestBody Floor floor) {
        return floorService.save(floor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        floorService.deleteById(id);
    }

    @GetMapping("")
    public List<Floor> findAllByBuilding(@RequestParam int building) {
        return floorService.findAllByBuilding(building);
    }
}
