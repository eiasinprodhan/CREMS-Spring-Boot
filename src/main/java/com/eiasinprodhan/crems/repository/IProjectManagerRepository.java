package com.eiasinprodhan.crems.repository;

import com.eiasinprodhan.crems.entity.ProjectManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectManagerRepository extends JpaRepository<ProjectManager, Integer> {
}
