package com.eiasinprodhan.crems.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "stages")
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private Date startDate;
    private  Date endDate;

    @OneToOne
    @JoinColumn(name = "floor_id")
    private Floor floor;

    @OneToMany
    @JoinColumn(name = "labour_id")
    private List<Labour> labours;
}
