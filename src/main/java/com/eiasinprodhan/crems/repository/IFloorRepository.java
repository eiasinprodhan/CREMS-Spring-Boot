package com.eiasinprodhan.crems.repository;

import com.eiasinprodhan.crems.entity.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFloorRepository extends JpaRepository<Floor, Integer> {
}
