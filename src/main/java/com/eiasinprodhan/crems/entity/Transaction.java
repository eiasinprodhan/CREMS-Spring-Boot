package com.eiasinprodhan.crems.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private Date date;
    private Long quantity;
    private Double amount;
    private boolean status;


}
