package com.eiasinprodhan.crems.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "labours")
public class Labour {
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


}
