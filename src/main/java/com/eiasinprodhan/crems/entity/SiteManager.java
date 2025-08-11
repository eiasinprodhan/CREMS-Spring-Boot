package com.eiasinprodhan.crems.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "site_managers")
public class SiteManager {
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

    @OneToMany
    @JoinColumn(name = "building_id", nullable = false)
    private List<Building> buildings;
}
