package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.RawMaterial;
import com.eiasinprodhan.crems.service.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rawmaterials")
public class RawMaterialRestController {

    @Autowired
    private RawMaterialService rawMaterialService;

    @PostMapping("/")
    public RawMaterial save(@RequestBody RawMaterial rawMaterial) {
        return rawMaterialService.save(rawMaterial);
    }


    @GetMapping("/")
    public List<RawMaterial> findAll() {
        return rawMaterialService.findAll();
    }

    @PutMapping("/")
    public RawMaterial update(@RequestBody RawMaterial rawMaterial) {
        return rawMaterialService.save(rawMaterial);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        rawMaterialService.delete(id);
    }


}
