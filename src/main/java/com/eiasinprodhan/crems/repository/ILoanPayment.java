package com.eiasinprodhan.crems.repository;

import com.eiasinprodhan.crems.entity.Booking;
import com.eiasinprodhan.crems.entity.LoanPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILoanPayment extends JpaRepository<LoanPayment, Integer> {
    List<LoanPayment> findLoanPaymentByBooking_Id(Integer bookingId);
}
