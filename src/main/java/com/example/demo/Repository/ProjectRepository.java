package com.example.demo.Repository;

import com.example.demo.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Projects, Long> {

	Projects findByName(String name);
    // You can define custom queries here if needed, for now we're using findAll() from JpaRepository
}
