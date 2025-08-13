package com.eiasinprodhan.crems.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "units")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String unitName;
    private Double area;
    private int bedrooms;
    private int bathrooms;
    private Double amount;
    private boolean isBooked;
}
