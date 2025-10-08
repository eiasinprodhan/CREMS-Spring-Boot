package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.RawMaterial;
import com.eiasinprodhan.crems.service.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rawmaterials")
public class RawMaterialRestController {

    @Autowired
    private RawMaterialService rawMaterialService;

    @PostMapping("/")
    public ResponseEntity<RawMaterial> save(@RequestBody RawMaterial rawMaterial) {
        RawMaterial saved = rawMaterialService.save(rawMaterial);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/")
    public ResponseEntity<List<RawMaterial>> findAll() {
        List<RawMaterial> materials = rawMaterialService.findAll();
        return ResponseEntity.ok(materials);
    }

    @PutMapping("/")
    public ResponseEntity<RawMaterial> update(@RequestBody RawMaterial rawMaterial) {
        RawMaterial updated = rawMaterialService.save(rawMaterial);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        RawMaterial existing = rawMaterialService.findById(id);
        if (existing != null) {
            rawMaterialService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
