package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.StockIn;
import com.eiasinprodhan.crems.service.StockInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stockindetails")
public class StockInRestController {

    @Autowired
    private StockInService stockInService;

    @GetMapping("/")
    public ResponseEntity<List<StockIn>> findAll() {
        List<StockIn> stockIns = stockInService.findAll();
        return ResponseEntity.ok(stockIns);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockIn> findById(@PathVariable Integer id) {
        StockIn stockIn = stockInService.findById(id);
        if (stockIn == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stockIn);
    }

    @PostMapping("/")
    public ResponseEntity<StockIn> save(@RequestBody StockIn stockIn) {
        StockIn saved = stockInService.save(stockIn);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/")
    public ResponseEntity<StockIn> update(@RequestBody StockIn stockIn) {
        StockIn updated = stockInService.save(stockIn);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        StockIn existing = stockInService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        stockInService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
