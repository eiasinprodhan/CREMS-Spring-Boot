package com.eiasinprodhan.crems.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stage_payment")
public class StagePayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int stageId;
    private String date;
    private boolean paid = false;

    public StagePayment() {
    }

    public StagePayment(boolean paid, String date, int stageId, int id) {
        this.paid = paid;
        this.date = date;
        this.stageId = stageId;
        this.id = id;
    }

    public StagePayment(int stageId, String date, boolean paid) {
        this.paid = paid;
        this.date = date;
        this.stageId = stageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStageId() {
        return stageId;
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
