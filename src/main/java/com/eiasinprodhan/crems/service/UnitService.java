package com.eiasinprodhan.crems.service;

import com.eiasinprodhan.crems.entity.Unit;
import com.eiasinprodhan.crems.repository.IUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnitService {

    @Autowired
    private IUnitRepository unitRepository;

    @Autowired
    private PhotoService photoService;

    public List<Unit> findAll() {
        return unitRepository.findAll();
    }

    public Unit findById(int id) {
        return unitRepository.findById(id).get();
    }

    public Unit save(Unit unit, MultipartFile[] files) {
        if(files != null && files.length > 0) {
            List<String> fileNames = photoService.savePhotos(unit, "/units",  files);
            unit.setPhotoUrls(fileNames);
        }

        return unitRepository.save(unit);
    }

    public Unit updateUnitForBook(Unit unit) {
        return unitRepository.save(unit);
    }

    public void delete(Integer id) {
        unitRepository.deleteById(id);
    }
}
