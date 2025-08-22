package com.eiasinprodhan.crems.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "stock_in_details")
public class StockIn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int rawMaterialId;
    private String name;
    private Date date;
    private Long quantity;
    private String unit;
    private Double unitPrice;
    private String supplier;
    private Double totalprice;

    public StockIn() {
    }

    public StockIn(int id, int rawMaterialId, String name, Date date, Long quantity, String unit, Double unitPrice, String supplier, Double totalprice) {
        this.id = id;
        this.rawMaterialId = rawMaterialId;
        this.name = name;
        this.date = date;
        this.quantity = quantity;
        this.unit = unit;
        this.unitPrice = unitPrice;
        this.supplier = supplier;
        this.totalprice = totalprice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRawMaterialId() {
        return rawMaterialId;
    }

    public void setRawMaterialId(int rawMaterialId) {
        this.rawMaterialId = rawMaterialId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }
}
