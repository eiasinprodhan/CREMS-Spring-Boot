package com.spring.crems.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private long budget;
    private Date startDate;
    private Date ExpectedEndDate;
    private String projectType;
    private String description;

    @OneToOne
    @JoinColumn(name = "projectManager_id")
    private ProjectManager projectManager;

    @OneToMany
    @JoinColumn(name = "building_id")
    private List<Building> building;

    public Project() {
    }

    public Project(int id, String name, long budget, Date startDate, Date expectedEndDate, String projectType, String description, ProjectManager projectManager) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.startDate = startDate;
        ExpectedEndDate = expectedEndDate;
        this.projectType = projectType;
        this.description = description;
        this.projectManager = projectManager;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getExpectedEndDate() {
        return ExpectedEndDate;
    }

    public void setExpectedEndDate(Date expectedEndDate) {
        ExpectedEndDate = expectedEndDate;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectManager getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(ProjectManager projectManager) {
        this.projectManager = projectManager;
    }
}
