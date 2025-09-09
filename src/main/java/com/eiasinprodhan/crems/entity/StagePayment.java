package com.eiasinprodhan.crems.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "stage_payment")
public class StagePayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String date;
    private boolean paid = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stage_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Stage stage;

    public StagePayment() {
    }

    public StagePayment(String date, boolean paid, Stage stage) {
        this.id = id;
        this.date = date;
        this.paid = paid;
        this.stage = stage;
    }

    public StagePayment(int id, String date, boolean paid, Stage stage) {
        this.id = id;
        this.date = date;
        this.paid = paid;
        this.stage = stage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
