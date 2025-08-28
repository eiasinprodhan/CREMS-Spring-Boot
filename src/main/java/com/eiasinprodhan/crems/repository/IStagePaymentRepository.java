package com.eiasinprodhan.crems.repository;

import com.eiasinprodhan.crems.entity.StagePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStagePaymentRepository extends JpaRepository<StagePayment, Integer> {
    List<StagePayment> findByStageId(Integer stageId);
    StagePayment findByStageIdAndDate(Integer stageId, String date);
}
