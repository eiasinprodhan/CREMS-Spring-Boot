package com.eiasinprodhan.crems.repository;

import com.eiasinprodhan.crems.entity.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRawMaterialRepository extends JpaRepository<RawMaterial,Integer> {
}
