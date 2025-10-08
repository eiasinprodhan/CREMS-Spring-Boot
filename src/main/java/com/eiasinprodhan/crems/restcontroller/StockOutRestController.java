package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.StockOut;
import com.eiasinprodhan.crems.service.StockOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stockoutdetails")
public class StockOutRestController {

    @Autowired
    private StockOutService stockOutService;

    @GetMapping("/")
    public ResponseEntity<List<StockOut>> findAll() {
        List<StockOut> stockOuts = stockOutService.findAll();
        return ResponseEntity.ok(stockOuts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockOut> findById(@PathVariable Integer id) {
        StockOut stockOut = stockOutService.findById(id);
        if (stockOut == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stockOut);
    }

    @PostMapping("/")
    public ResponseEntity<StockOut> save(@RequestBody StockOut stockOut) {
        System.out.println("Saving StockOut: " + stockOut);
        StockOut saved = stockOutService.save(stockOut);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/")
    public ResponseEntity<StockOut> update(@RequestBody StockOut stockOut) {
        StockOut updated = stockOutService.save(stockOut);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        StockOut existing = stockOutService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        stockOutService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<StockOut>> findByStageId(@RequestParam Integer stageid) {
        List<StockOut> stockOuts = stockOutService.findByStageId(stageid);
        return ResponseEntity.ok(stockOuts);
    }
}
