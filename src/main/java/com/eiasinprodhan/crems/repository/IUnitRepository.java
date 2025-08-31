package com.eiasinprodhan.crems.repository;

import com.eiasinprodhan.crems.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUnitRepository extends JpaRepository<Unit, Integer> {
    List<Unit> findUnitByBuildingId(int buildingId);
}
