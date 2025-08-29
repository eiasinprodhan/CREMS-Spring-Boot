package com.eiasinprodhan.crems.service;

import com.eiasinprodhan.crems.entity.Building;
import com.eiasinprodhan.crems.repository.IBuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class BuildingService {

    @Autowired
    private IBuildingRepository  buildingRepository;

    @Autowired
    private PhotoService photoService;

    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    public Building getBuildingById(int id) {
        return buildingRepository.findById(id).get();
    }

    public Building saveBuilding(Building building, MultipartFile file) {
        if(file != null && !file.isEmpty()) {
            String fileName = photoService.savePhoto(building, "/buildings",  file);
            building.setPhoto(fileName);
        }
        return buildingRepository.save(building);
    }

    public void delete(int id) {
        buildingRepository.deleteById(id);
    }

    public List<Building> findAllByProject(int project) {
        return buildingRepository.findAllByProject(project);
    }

    public List<Building> findBuildingsBySiteManager(int siteManager) {
        return buildingRepository.findBuildingsBySiteManager(siteManager);
    }
}
