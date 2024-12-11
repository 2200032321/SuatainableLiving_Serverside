package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Courses;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Long> {
    Courses findByCourseName(String courseName);  // Matches the courseName field in Courses
}
