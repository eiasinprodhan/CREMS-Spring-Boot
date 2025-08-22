package com.eiasinprodhan.crems.service;

import com.eiasinprodhan.crems.entity.Building;
import com.eiasinprodhan.crems.repository.IBuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {

    @Autowired
    private IBuildingRepository  buildingRepository;

    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    public Building getBuildingById(int id) {
        return buildingRepository.findById(id).get();
    }

    public Building saveBuilding(Building building) {
        return buildingRepository.save(building);
    }

    public Building updateBuilding(Building building) {
        return buildingRepository.save(building);
    }

    public void delete(int id) {
        buildingRepository.deleteById(id);
    }

    public List<Building> findAllByProject(int project) {
        return buildingRepository.findAllByProject(project);
    }
}
