package com.eiasinprodhan.crems.repository;

import com.eiasinprodhan.crems.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStageRepository extends JpaRepository<Stage, Integer> {
    List<Stage> findAllByFloor(Integer floor);
}
