package com.eiasinprodhan.crems.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "buildings")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String type;
    private String location;
    private int project;
    private int siteManager;
    private int floorCount;
    private int unitCount;
    private String photo;

    public Building() {
    }

    public Building(int id, String name, String type, String location, int project, int siteManager, int floorCount, int unitCount, String photo) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.location = location;
        this.project = project;
        this.siteManager = siteManager;
        this.floorCount = floorCount;
        this.unitCount = unitCount;
        this.photo = photo;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public int getSiteManager() {
        return siteManager;
    }

    public void setSiteManager(int siteManager) {
        this.siteManager = siteManager;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public int getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(int unitCount) {
        this.unitCount = unitCount;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
