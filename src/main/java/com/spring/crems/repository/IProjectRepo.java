package com.spring.crems.repository;

import com.spring.crems.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepo extends JpaRepository<Project, Integer> {
}
