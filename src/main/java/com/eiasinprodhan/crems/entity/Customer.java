package com.eiasinprodhan.crems.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String phone;
    private int nid;
    private Date joiningDate;
    private String salaryType;
    private Long salary;
    private String status;
    private String photo;
    private String country;

    @OneToOne
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;
}
