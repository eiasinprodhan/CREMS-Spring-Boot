package com.eiasinprodhan.crems.service;

import com.eiasinprodhan.crems.entity.Booking;
import com.eiasinprodhan.crems.repository.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private IBookingRepository bookingRepository;

    public Booking save(Booking booking){
        return bookingRepository.save(booking);
    }

    public List<Booking> findAll(){
        return bookingRepository.findAll();
    }

    public Booking findById(Integer id){
        return bookingRepository.findById(id).orElse(null);
    }

    public void deleteById(Integer id){
        bookingRepository.deleteById(id);
    }
}
