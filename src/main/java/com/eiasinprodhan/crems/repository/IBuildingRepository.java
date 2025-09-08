package com.eiasinprodhan.crems.repository;

import com.eiasinprodhan.crems.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBuildingRepository extends JpaRepository<Building, Integer> {
    List<Building> findBuildingsByProject_Id(Integer project_id);

    List<Building> findBuildingsBySiteManager_Id(int siteManagerId);
}
