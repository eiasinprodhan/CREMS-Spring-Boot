package com.eiasinprodhan.crems.service;

import com.eiasinprodhan.crems.entity.StockIn;
import com.eiasinprodhan.crems.repository.IStockInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockInService {

    @Autowired
    private IStockInRepository  stockInRepository;

    public List<StockIn> findAll() {
        return stockInRepository.findAll();
    }

    public StockIn findById(int id) {
        return stockInRepository.findById(id).get();
    }

    public StockIn save(StockIn stockIn) {
        return stockInRepository.save(stockIn);
    }

    public void delete(Integer id){
        stockInRepository.deleteById(id);
    }
}
