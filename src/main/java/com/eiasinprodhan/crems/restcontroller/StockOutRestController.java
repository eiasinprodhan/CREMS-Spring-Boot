package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.StockOut;
import com.eiasinprodhan.crems.service.StockOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stockoutdetails")
@CrossOrigin("*")
public class StockOutRestController {

    @Autowired
    private StockOutService stockOutService;

    @GetMapping("/")
    public List<StockOut> findAll() {
        return stockOutService.findAll();
    }

    @GetMapping("/{id}")
    public StockOut findById(@PathVariable Integer id) {
        return stockOutService.findById(id);
    }

    @PostMapping("/")
    public StockOut save(@RequestBody StockOut stockOut) {
        return stockOutService.save(stockOut);
    }

    @PutMapping("/")
    public StockOut update(@RequestBody StockOut stockOut) {
        return stockOutService.save(stockOut);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        stockOutService.deleteById(id);
    }

    @GetMapping("")
    public List<StockOut> findByStageId(@RequestParam Integer stageid) {
        return stockOutService.findByStageId(stageid);
    }

}
