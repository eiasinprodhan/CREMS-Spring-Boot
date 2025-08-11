package com.eiasinprodhan.crems.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "buildings")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String type;
    private int floorCount;
    private int unitCount;
    private String photo;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToOne
    @JoinColumn(name = "site_manager")
    private SiteManager siteManager;

    @OneToMany
    @JoinColumn(name = "floor_id")
    private List<Floor> floors;

    public Building() {
    }

    public Building(int id, String name, String type, int floorCount, int unitCount, String photo, Project project, SiteManager siteManager, List<Floor> floors) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.floorCount = floorCount;
        this.unitCount = unitCount;
        this.photo = photo;
        this.project = project;
        this.siteManager = siteManager;
        this.floors = floors;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public SiteManager getSiteManager() {
        return siteManager;
    }

    public void setSiteManager(SiteManager siteManager) {
        this.siteManager = siteManager;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }
}
