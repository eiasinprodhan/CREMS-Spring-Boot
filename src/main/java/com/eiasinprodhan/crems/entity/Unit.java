package com.eiasinprodhan.crems.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "units")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int floorId;
    private int buildingId;


    private String unitNumber;
    private Double area;
    private int bedrooms;
    private int bathrooms;
    private boolean isBooked;

    @ElementCollection
    private List<String> photoUrls;

    private Double price;
    private Double interestRate;

    public Unit() {
    }

    public Unit(int id, int floorId, int buildingId, String unitNumber, Double area, int bedrooms, int bathrooms, boolean isBooked, List<String> photoUrls, Double price, Double interestRate) {
        this.id = id;
        this.floorId = floorId;
        this.buildingId = buildingId;
        this.unitNumber = unitNumber;
        this.area = area;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.isBooked = isBooked;
        this.photoUrls = photoUrls;
        this.price = price;
        this.interestRate = interestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public String getName(){
        return unitNumber;
    }

    public void setName(String name){
        this.unitNumber = name;
    }
}
