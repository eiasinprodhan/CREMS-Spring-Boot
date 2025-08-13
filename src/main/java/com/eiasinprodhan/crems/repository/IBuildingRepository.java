package com.eiasinprodhan.crems.repository;

import com.eiasinprodhan.crems.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBuildingRepository extends JpaRepository<Building, Integer> {
}
