package com.eiasinprodhan.crems.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private Long budget;
    private Date startDate;
    private Date expectedEndDate;
    private String projectType;
    private int projectManager;
    private String description;

    public Project() {
    }

    public Project(int id, String name, Long budget, Date startDate, Date expectedEndDate, String projectType, int projectManager, String description) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.startDate = startDate;
        this.expectedEndDate = expectedEndDate;
        this.projectType = projectType;
        this.projectManager = projectManager;
        this.description = description;
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

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getExpectedEndDate() {
        return expectedEndDate;
    }

    public void setExpectedEndDate(Date expectedEndDate) {
        this.expectedEndDate = expectedEndDate;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public int getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(int projectManager) {
        this.projectManager = projectManager;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}