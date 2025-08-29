package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.Building;
import com.eiasinprodhan.crems.service.BuildingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public Building createBuilding(
            @RequestPart(value = "building") String buildingJson,
            @RequestParam(value = "photo")MultipartFile file
            ) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Building building = mapper.readValue(buildingJson, Building.class);

        return buildingService.saveBuilding(building, file);
    }

    @PutMapping("/")
    public Building updateBuilding(
            @RequestPart(value = "building") String buildingJson,
            @RequestParam(value = "photo")MultipartFile file
    ) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Building building = mapper.readValue(buildingJson, Building.class);

        return buildingService.saveBuilding(building, file);
    }

    @DeleteMapping("/{id}")
    public void deleteBuilding(@PathVariable int id) {
        buildingService.delete(id);
    }

    @GetMapping("")
    public List<Building> findAllByProject(@RequestParam Integer project) {
        return buildingService.findAllByProject(project);
    }

    @GetMapping("/siteManager")
    public List<Building> findBuildingsBySiteManager(@RequestParam Integer siteManager) {
        return buildingService.findBuildingsBySiteManager(siteManager);
    }
}
