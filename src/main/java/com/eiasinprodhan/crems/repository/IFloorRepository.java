package com.eiasinprodhan.crems.repository;

import com.eiasinprodhan.crems.entity.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFloorRepository extends JpaRepository<Floor, Integer> {
    List<Floor> findAllByBuilding(int building);
}
