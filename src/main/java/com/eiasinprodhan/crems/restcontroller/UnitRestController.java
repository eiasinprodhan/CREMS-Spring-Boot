package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.Unit;
import com.eiasinprodhan.crems.service.UnitService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/units")
@CrossOrigin("*")
public class UnitRestController {

    @Autowired
    private UnitService unitService;

    @GetMapping("/")
    public List<Unit> getUnits() {
        return unitService.findAll();
    }

    @GetMapping("/{id}")
    public Unit getUnit(@PathVariable Integer id) {
        return unitService.findById(id);
    }

    @PostMapping("/")
    public Unit save(
            @RequestPart(value = "unit") String unitJson,
            @RequestParam(value = "photos") MultipartFile[] photos
    ) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Unit unit = mapper.readValue(unitJson, Unit.class);

        return  unitService.save(unit, photos);
    }

    @PutMapping("/")
    public Unit update(
            @RequestPart(value = "unit") String unitJson,
            @RequestParam(value = "photos") MultipartFile[] photos
    ) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Unit unit = mapper.readValue(unitJson, Unit.class);

        return  unitService.save(unit, photos);
    }

    @PutMapping("/updateunitforbook")
    public Unit updateUnitForBook(@RequestBody Unit unit) {
        return unitService.updateUnitForBook(unit);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        unitService.delete(id);
    }

    @GetMapping("/productdetails/{id}")
    public List<Unit> findUnitByBuildingId(@PathVariable Integer id) {
        return unitService.findByBuildingId(id);
    }
}
