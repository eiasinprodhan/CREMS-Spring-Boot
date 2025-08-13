package com.eiasinprodhan.crems.service;

import com.eiasinprodhan.crems.entity.Floor;
import com.eiasinprodhan.crems.repository.IFloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorService {

    @Autowired
    private IFloorRepository  floorRepository;

    public List<Floor> findAll() {
        return floorRepository.findAll();
    }

    public Floor findById(int id) {
        return floorRepository.findById(id).get();
    }

    public Floor save(Floor floor) {
        return floorRepository.save(floor);
    }

    public void deleteById(int id) {
        floorRepository.deleteById(id);
    }
}
