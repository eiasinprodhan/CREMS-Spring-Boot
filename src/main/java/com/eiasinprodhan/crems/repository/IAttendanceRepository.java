package com.eiasinprodhan.crems.repository;

import com.eiasinprodhan.crems.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAttendanceRepository extends JpaRepository<Attendance, Integer> {
    List<Attendance> findAttendancesByStageId(Integer stageId);
}
