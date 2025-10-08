package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.Building;
import com.eiasinprodhan.crems.service.BuildingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/buildings")
public class BuildingRestController {

    @Autowired
    private BuildingService buildingService;

    @GetMapping("/")
    public ResponseEntity<List<Building>> getAllBuildings() {
        List<Building> buildings = buildingService.getAllBuildings();
        return ResponseEntity.ok(buildings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Building> getBuildingById(@PathVariable int id) {
        Building building = buildingService.getBuildingById(id);
        if (building != null) {
            return ResponseEntity.ok(building);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Building> createBuilding(
            @RequestPart(value = "building") String buildingJson,
            @RequestParam(value = "photo") MultipartFile file
    ) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Building building = mapper.readValue(buildingJson, Building.class);

        Building savedBuilding = buildingService.saveBuilding(building, file);
        return ResponseEntity.ok(savedBuilding);
    }

    @PutMapping("/")
    public ResponseEntity<Building> updateBuilding(
            @RequestPart(value = "building") String buildingJson,
            @RequestParam(value = "photo") MultipartFile file
    ) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Building building = mapper.readValue(buildingJson, Building.class);

        Building updatedBuilding = buildingService.saveBuilding(building, file);
        return ResponseEntity.ok(updatedBuilding);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuilding(@PathVariable int id) {
        Building building = buildingService.getBuildingById(id);
        if (building != null) {
            buildingService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Building>> findAllByProject(@RequestParam Integer project) {
        List<Building> buildings = buildingService.findAllByProject(project);
        return ResponseEntity.ok(buildings);
    }

    @GetMapping("/siteManager")
    public ResponseEntity<List<Building>> findBuildingsBySiteManager(@RequestParam Integer siteManager) {
        List<Building> buildings = buildingService.findBuildingsBySiteManager(siteManager);
        return ResponseEntity.ok(buildings);
    }
}
