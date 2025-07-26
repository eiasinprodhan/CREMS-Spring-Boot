package com.spring.crems.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String  name;
    private long budget;
    private LocalDate startDate;
    private LocalDate ExpectedEndDate;
    private String projectType;
    private int projectManager;
    private String description;

    public Project() {
    }

    public Project(int id, String name, long budget, LocalDate startDate, LocalDate expectedEndDate, String projectType, int projectManager, String description) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.startDate = startDate;
        ExpectedEndDate = expectedEndDate;
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

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getExpectedEndDate() {
        return ExpectedEndDate;
    }

    public void setExpectedEndDate(LocalDate expectedEndDate) {
        ExpectedEndDate = expectedEndDate;
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
