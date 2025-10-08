package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.LoanPayment;
import com.eiasinprodhan.crems.service.LoanPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loanpayments")
public class LoanPaymentRestController {

    @Autowired
    private LoanPaymentService loanPaymentService;

    @PostMapping("/")
    public ResponseEntity<LoanPayment> createLoanPayment(@RequestBody LoanPayment loanPayment) {
        LoanPayment saved = loanPaymentService.saveLoanPayment(loanPayment);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/")
    public ResponseEntity<List<LoanPayment>> getLoanPayments() {
        List<LoanPayment> list = loanPaymentService.getLoanPayments();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanPayment> getLoanPaymentById(@PathVariable Integer id) {
        LoanPayment loanPayment = loanPaymentService.getLoanPaymentById(id);
        if (loanPayment != null) {
            return ResponseEntity.ok(loanPayment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/")
    public ResponseEntity<LoanPayment> updateLoanPayment(@RequestBody LoanPayment loanPayment) {
        LoanPayment updated = loanPaymentService.saveLoanPayment(loanPayment);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoanPaymentById(@PathVariable Integer id) {
        LoanPayment loanPayment = loanPaymentService.getLoanPaymentById(id);
        if (loanPayment != null) {
            loanPaymentService.deleteLoanPaymentById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/booking/{id}")
    public ResponseEntity<List<LoanPayment>> findLoanPaymentByBooking_Id(@PathVariable Integer id) {
        List<LoanPayment> list = loanPaymentService.findLoanPaymentByBooking_Id(id);
        return ResponseEntity.ok(list);
    }
}
