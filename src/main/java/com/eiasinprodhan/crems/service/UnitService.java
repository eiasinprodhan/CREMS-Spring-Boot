package com.eiasinprodhan.crems.service;

import com.eiasinprodhan.crems.entity.Unit;
import com.eiasinprodhan.crems.repository.IUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {

    @Autowired
    private IUnitRepository unitRepository;

    public List<Unit> findAll() {
        return unitRepository.findAll();
    }

    public Unit findById(int id) {
        return unitRepository.findById(id).get();
    }

    public Unit save(Unit unit) {
        return unitRepository.save(unit);
    }

    public void delete(Integer id) {
        unitRepository.deleteById(id);
    }
}
