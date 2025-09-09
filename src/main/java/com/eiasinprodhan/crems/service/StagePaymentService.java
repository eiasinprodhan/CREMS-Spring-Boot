package com.eiasinprodhan.crems.service;

import com.eiasinprodhan.crems.entity.Stage;
import com.eiasinprodhan.crems.entity.StagePayment;
import com.eiasinprodhan.crems.repository.IStagePaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StagePaymentService {

    @Autowired
    private IStagePaymentRepository repository;

    public List<StagePayment> getPaymentsByStage(Integer stageId) {
        return repository.findByStageId(stageId);
    }

    public StagePayment savePayment(Stage stage, String date, boolean paid) {
        StagePayment existing = repository.findByStageIdAndDate(stage.getId(), date);
        if (existing != null) {
            existing.setPaid(paid);
            return repository.save(existing);
        } else {
            StagePayment newPayment = new StagePayment(date, paid, stage);
            return repository.save(newPayment);
        }
    }
}
