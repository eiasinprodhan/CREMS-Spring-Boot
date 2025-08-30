package com.eiasinprodhan.crems.repository;

import com.eiasinprodhan.crems.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Integer> {
}
