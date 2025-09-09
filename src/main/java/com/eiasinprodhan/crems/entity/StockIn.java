package com.eiasinprodhan.crems.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "stock_in_details")
public class StockIn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private Date date;
    private Long quantity;
    private String unit;
    private Double unitPrice;
    private String supplier;
    private Double totalprice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "raw_materials_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private RawMaterial rawMaterial;

    public StockIn() {
    }

    public StockIn(int id, String name, Date date, Long quantity, String unit, Double unitPrice, String supplier, Double totalprice, RawMaterial rawMaterial) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.quantity = quantity;
        this.unit = unit;
        this.unitPrice = unitPrice;
        this.supplier = supplier;
        this.totalprice = totalprice;
        this.rawMaterial = rawMaterial;
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

    public RawMaterial getRawMaterial() {
        return rawMaterial;
    }

    public void setRawMaterial(RawMaterial rawMaterial) {
        this.rawMaterial = rawMaterial;
    }
}
