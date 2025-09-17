package com.eiasinprodhan.crems.service;

import com.eiasinprodhan.crems.entity.LoanPayment;
import com.eiasinprodhan.crems.repository.ILoanPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanPaymentService {

    @Autowired
    private ILoanPayment iLoanPayment;

    public LoanPayment saveLoanPayment(LoanPayment loanPayment) {
        return iLoanPayment.save(loanPayment);
    }

    public List<LoanPayment> getLoanPayments() {
        return iLoanPayment.findAll();
    }

    public LoanPayment getLoanPaymentById(Integer id) {
        return iLoanPayment.findById(id).orElse(null);
    }

    public void deleteLoanPaymentById(Integer id) {
        iLoanPayment.deleteById(id);
    }

    public List<LoanPayment> findLoanPaymentByBooking_Id(Integer bookingId) {
        return iLoanPayment.findLoanPaymentByBooking_Id(bookingId);
    }
}
