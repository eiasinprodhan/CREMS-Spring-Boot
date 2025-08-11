package com.eiasinprodhan.crems.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private Date date;
    private Double amount;

    @OneToOne
    @JoinColumn(name = "unit")
    private Unit unit;

    @OneToOne
    @JoinColumn(name = "customer")
    private Customer customer;

}
