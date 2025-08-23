package com.eiasinprodhan.crems.service;

import com.eiasinprodhan.crems.entity.Attendance;
import com.eiasinprodhan.crems.repository.IAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private IAttendanceRepository iAttendanceRepository;

    public List<Attendance> findAll() {
        return iAttendanceRepository.findAll();
    }

    public Attendance findById(Integer id) {
        return iAttendanceRepository.findById(id).orElse(null);
    }

    public Attendance save(Attendance attendance) {
        return iAttendanceRepository.save(attendance);
    }

    public void deleteById(Integer id) {
        iAttendanceRepository.deleteById(id);
    }

    public List<Attendance> findByStageId(Integer stageId) {
        return iAttendanceRepository.findAttendancesByStageId(stageId);
    }
}
