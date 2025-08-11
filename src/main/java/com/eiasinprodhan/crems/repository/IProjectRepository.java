package com.eiasinprodhan.crems.repository;

import com.eiasinprodhan.crems.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Integer> {
}
