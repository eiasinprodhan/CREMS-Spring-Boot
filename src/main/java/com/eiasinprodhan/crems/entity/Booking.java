package com.eiasinprodhan.crems.entity;


import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int buildingId;
    private int floorId;
    private int unitId;
    private int customerId;
    private Date date;
    private boolean isLoan;
    private double downPayment;
    private Double interestRate;
    private int year;
    private Double amount;
    private Double discount;
    private Double dueAmount;
    private Double emiAmount;

    public Booking() {
    }

    public Booking(int id, int buildingId, int floorId, int unitId, int customerId, Date date, boolean isLoan, double downPayment, Double interestRate, int year, Double amount, Double discount, Double dueAmount, Double emiAmount) {
        this.id = id;
        this.buildingId = buildingId;
        this.floorId = floorId;
        this.unitId = unitId;
        this.customerId = customerId;
        this.date = date;
        this.isLoan = isLoan;
        this.downPayment = downPayment;
        this.interestRate = interestRate;
        this.year = year;
        this.amount = amount;
        this.discount = discount;
        this.dueAmount = dueAmount;
        this.emiAmount = emiAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isLoan() {
        return isLoan;
    }

    public void setLoan(boolean loan) {
        isLoan = loan;
    }

    public double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public Double getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(Double emiAmount) {
        this.emiAmount = emiAmount;
    }
}
