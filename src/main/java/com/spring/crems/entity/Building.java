package com.spring.crems.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "buildings")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn
    private Project project;
}
