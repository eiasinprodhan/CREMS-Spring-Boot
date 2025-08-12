package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.RawMaterial;
import com.eiasinprodhan.crems.service.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rawmaterials/")
public class RawMaterialRestController {

    @Autowired
    private RawMaterialService  rawMaterialService;

    @GetMapping("")
    public ResponseEntity<List<RawMaterial>> getAllRawMaterials() {
        try{
            List<RawMaterial> rawMaterials =  rawMaterialService.findAll();
            return new ResponseEntity<>(rawMaterials, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("save")
    public ResponseEntity<RawMaterial> saveRawMaterial(@RequestBody RawMaterial rawMaterial) {
        try {
            rawMaterialService.save(rawMaterial);
            return new ResponseEntity<>(rawMaterial, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
