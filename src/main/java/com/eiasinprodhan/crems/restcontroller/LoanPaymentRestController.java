package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.LoanPayment;
import com.eiasinprodhan.crems.service.LoanPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loanpayments")
public class LoanPaymentRestController {

    @Autowired
    private LoanPaymentService loanPaymentService;

    @PostMapping("/")
    public LoanPayment createLoanPayment(@RequestBody LoanPayment loanPayment) {
        return loanPaymentService.saveLoanPayment(loanPayment);
    }

    @GetMapping("/")
    public List<LoanPayment> getLoanPayments() {
        return loanPaymentService.getLoanPayments();
    }

    @GetMapping("/{id}")
    public LoanPayment getLoanPaymentById(@PathVariable Integer id) {
        return loanPaymentService.getLoanPaymentById(id);
    }

    @PutMapping("/")
    public LoanPayment updateLoanPayment(@RequestBody LoanPayment loanPayment) {
        return loanPaymentService.saveLoanPayment(loanPayment);
    }

    @DeleteMapping("/{id}")
    public void deleteLoanPaymentById(@PathVariable Integer id) {
        loanPaymentService.deleteLoanPaymentById(id);
    }

    @GetMapping("/booking/{id}")
    public List<LoanPayment> findLoanPaymentByBooking_Id(@PathVariable Integer id) {
        return loanPaymentService.findLoanPaymentByBooking_Id(id);
    }
}
