package com.eiasinprodhan.crems.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "attendances")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer employeeId;
    private Integer stageId;
    private String date;
    private String status;
    private Double salary;

    public Attendance() {
    }

    public Attendance(Integer id, Integer employeeId, Integer stageId, String date, String status, Double salary) {
        this.id = id;
        this.employeeId = employeeId;
        this.stageId = stageId;
        this.date = date;
        this.status = status;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getStageId() {
        return stageId;
    }

    public void setStageId(Integer stageId) {
        this.stageId = stageId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
