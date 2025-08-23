package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.Unit;
import com.eiasinprodhan.crems.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Unit save(Unit unit) {
        return unitService.save(unit);
    }

    @PutMapping("/")
    public Unit update(Unit unit) {
        return unitService.save(unit);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        unitService.delete(id);
    }
}
