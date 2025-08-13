package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.Building;
import com.eiasinprodhan.crems.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buildings")
@CrossOrigin("*")
public class BuildingRestController {

    @Autowired
    private BuildingService  buildingService;

    @GetMapping("/")
    public List<Building> getAllBuildings() {
        return buildingService.getAllBuildings();
    }

    @GetMapping("/{id}")
    public Building getBuildingById(@PathVariable int id) {
        return buildingService.getBuildingById(id);
    }

    @PostMapping("/")
    public Building createBuilding(@RequestBody Building building) {
        return buildingService.saveBuilding(building);
    }

    @PutMapping("/")
    public Building updateBuilding(@RequestBody Building building) {
        return buildingService.updateBuilding(building);
    }

    @DeleteMapping("/{id}")
    public void deleteBuilding(@PathVariable int id) {
        buildingService.delete(id);
    }
}
