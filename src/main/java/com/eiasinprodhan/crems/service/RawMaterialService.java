package com.eiasinprodhan.crems.service;

import com.eiasinprodhan.crems.entity.RawMaterial;
import com.eiasinprodhan.crems.repository.IRawMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RawMaterialService {

    @Autowired
    private IRawMaterialRepository rawMaterialRepository;

    public RawMaterial save(RawMaterial rawMaterial) {
        return rawMaterialRepository.save(rawMaterial);
    }

    public List<RawMaterial> findAll() {
        return rawMaterialRepository.findAll();
    }

    public RawMaterial findById(int id) {
        return rawMaterialRepository.findById(id).get();
    }

    public void delete(RawMaterial rawMaterial) {
        rawMaterialRepository.delete(rawMaterial);
    }
}
