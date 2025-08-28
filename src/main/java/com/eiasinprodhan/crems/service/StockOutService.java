package com.eiasinprodhan.crems.service;

import com.eiasinprodhan.crems.entity.StockOut;
import com.eiasinprodhan.crems.repository.IStockOutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockOutService {

    @Autowired
    private IStockOutRepository stockOutRepository;

    public List<StockOut> findAll() {
        return stockOutRepository.findAll();
    }

    public StockOut findById(Integer id) {
        return stockOutRepository.findById(id).get();
    }

    public StockOut save(StockOut stockOut) {
        return stockOutRepository.save(stockOut);
    }

    public void deleteById(Integer id) {
        stockOutRepository.deleteById(id);
    }

    public List<StockOut> findByStageId(int stageId) {
        return stockOutRepository.findStockOutByStageId(stageId);
    }
}
