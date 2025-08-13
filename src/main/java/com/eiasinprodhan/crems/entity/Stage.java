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
    private Date endDate;
    private int floor;

    @ElementCollection
    List<Integer> labours;

    public Stage() {
    }

    public Stage(int id, String name, Date startDate, Date endDate, int floor, List<Integer> labours) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.floor = floor;
        this.labours = labours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public List<Integer> getLabours() {
        return labours;
    }

    public void setLabours(List<Integer> labours) {
        this.labours = labours;
    }
}
