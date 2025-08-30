package com.eiasinprodhan.crems.restcontroller;

import com.eiasinprodhan.crems.entity.Booking;
import com.eiasinprodhan.crems.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin("*")
public class BookingRestController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/")
    public List<Booking> findAll(){
        return bookingService.findAll();
    }

    @GetMapping("/{id}")
    public Booking findById(@PathVariable Integer id){
        return bookingService.findById(id);
    }

    @PostMapping("/")
    public Booking create(@RequestBody Booking booking){
        return bookingService.save(booking);
    }

    @PutMapping("/")
    public Booking update(@RequestBody Booking booking){
        return bookingService.save(booking);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        bookingService.deleteById(id);
    }
}
