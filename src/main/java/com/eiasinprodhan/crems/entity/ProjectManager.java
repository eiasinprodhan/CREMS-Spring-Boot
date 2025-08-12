package com.eiasinprodhan.crems.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "project_managers")
public class ProjectManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String phone;
    private int nid;
    private Date joiningDate;
    private String salaryType;
    private Long salary;
    private String status;
    private String photo;
    private String country;

    @OneToMany(mappedBy = "projectManager", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Project> projects;

    public ProjectManager() {
    }

    public ProjectManager(int id, String name, String email, String phone, int nid, Date joiningDate, String salaryType, Long salary, String status, String photo, String country, List<Project> projects) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.nid = nid;
        this.joiningDate = joiningDate;
        this.salaryType = salaryType;
        this.salary = salary;
        this.status = status;
        this.photo = photo;
        this.country = country;
        this.projects = projects;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(String salaryType) {
        this.salaryType = salaryType;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
