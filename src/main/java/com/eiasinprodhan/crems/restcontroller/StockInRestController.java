package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.StockIn;
import com.eiasinprodhan.crems.service.StockInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stockindetails")
@CrossOrigin("*")
public class StockInRestController {

    @Autowired
    private StockInService stockInService;

    @GetMapping("/")
    public List<StockIn> findAll() {
        return stockInService.findAll();
    }

    @GetMapping("/{id}")
    public StockIn findById(@PathVariable Integer id) {
        return stockInService.findById(id);
    }

    @PostMapping("/")
    public StockIn save(@RequestBody StockIn stockIn) {
        return stockInService.save(stockIn);
    }

    @PutMapping("/")
    public StockIn update(@RequestBody StockIn stockIn) {
        return stockInService.save(stockIn);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        stockInService.delete(id);
    }

}
