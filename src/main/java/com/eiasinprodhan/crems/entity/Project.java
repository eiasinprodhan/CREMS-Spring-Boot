package com.eiasinprodhan.crems.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private Long budget;
    private Date startDate;
    private Date expectedEndDate;
    private String projectType;
    private int projectManager;
    private String description;

}