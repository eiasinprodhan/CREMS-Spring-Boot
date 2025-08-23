package com.eiasinprodhan.crems.repository;

import com.eiasinprodhan.crems.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUnitRepository extends JpaRepository<Unit, Integer> {
}
