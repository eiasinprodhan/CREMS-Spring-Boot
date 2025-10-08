package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.Unit;
import com.eiasinprodhan.crems.service.UnitService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/units")
public class UnitRestController {

    @Autowired
    private UnitService unitService;

    @GetMapping("/")
    public ResponseEntity<List<Unit>> getUnits() {
        List<Unit> units = unitService.findAll();
        return ResponseEntity.ok(units);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unit> getUnit(@PathVariable Integer id) {
        Unit unit = unitService.findById(id);
        if (unit == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(unit);
    }

    @PostMapping("/")
    public ResponseEntity<Unit> save(
            @RequestPart(value = "unit") String unitJson,
            @RequestParam(value = "photos") MultipartFile[] photos
    ) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Unit unit = mapper.readValue(unitJson, Unit.class);

        Unit savedUnit = unitService.save(unit, photos);
        return ResponseEntity.ok(savedUnit);
    }

    @PutMapping("/")
    public ResponseEntity<Unit> update(
            @RequestPart(value = "unit") String unitJson,
            @RequestParam(value = "photos") MultipartFile[] photos
    ) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Unit unit = mapper.readValue(unitJson, Unit.class);

        Unit updatedUnit = unitService.save(unit, photos);
        if (updatedUnit == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUnit);
    }

    @PutMapping("/updateunitforbook")
    public ResponseEntity<Unit> updateUnitForBook(@RequestBody Unit unit) {
        Unit updatedUnit = unitService.updateUnitForBook(unit);
        if (updatedUnit == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUnit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Unit existing = unitService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        unitService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/productdetails/{id}")
    public ResponseEntity<List<Unit>> findUnitByBuildingId(@PathVariable Integer id) {
        List<Unit> units = unitService.findByBuildingId(id);
        return ResponseEntity.ok(units);
    }
}
