package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.StagePayment;
import com.eiasinprodhan.crems.service.StagePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stagepayments")
@CrossOrigin("*")
public class StagePaymentRestController {

    @Autowired
    private StagePaymentService service;

    @GetMapping("/{stageId}")
    public List<StagePayment> getPaymentsByStage(@PathVariable Integer stageId) {
        return service.getPaymentsByStage(stageId);
    }

    @PostMapping("/")
    public StagePayment savePayment(@RequestBody StagePayment payload) {
        return service.savePayment(payload.getStageId(), payload.getDate(), payload.isPaid());
    }
}
