package com.eiasinprodhan.crems.service;

import com.eiasinprodhan.crems.entity.Stage;
import com.eiasinprodhan.crems.repository.IStageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StageService {

    @Autowired
    private IStageRepository stageRepository;

    public List<Stage> findAll(){
        return stageRepository.findAll();
    }

    public Stage findById(Integer id){
        return stageRepository.findById(id).get();
    }

    public Stage save(Stage stage){
        return stageRepository.save(stage);
    }

    public void deleteById(Integer id){
        stageRepository.deleteById(id);
    }

    public List<Stage> findAllByFloor(Integer floor){
        return stageRepository.findAllByFloor(floor);
    }
}
