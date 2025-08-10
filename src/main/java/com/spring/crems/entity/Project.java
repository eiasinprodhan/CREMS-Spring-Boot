package com.spring.crems.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String  name;
    private long budget;
    private Date startDate;
    private Date ExpectedEndDate;
    private String projectType;
    private String description;


}
