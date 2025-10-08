package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.StagePayment;
import com.eiasinprodhan.crems.service.StagePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stagepayments")
public class StagePaymentRestController {

    @Autowired
    private StagePaymentService service;

    @GetMapping("/{stageId}")
    public ResponseEntity<List<StagePayment>> getPaymentsByStage(@PathVariable Integer stageId) {
        List<StagePayment> payments = service.getPaymentsByStage(stageId);
        if (payments == null || payments.isEmpty()) {
            return ResponseEntity.noContent().build(); // or .notFound() if preferred
        }
        return ResponseEntity.ok(payments);
    }

    @PostMapping("/")
    public ResponseEntity<StagePayment> savePayment(@RequestBody StagePayment payload) {
        StagePayment saved = service.savePayment(payload.getStageId(), payload.getDate(), payload.isPaid());
        if (saved == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(saved);
    }
}
