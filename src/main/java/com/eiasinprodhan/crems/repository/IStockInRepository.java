package com.eiasinprodhan.crems.repository;

import com.eiasinprodhan.crems.entity.StockIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStockInRepository extends JpaRepository<StockIn,Integer> {
}
