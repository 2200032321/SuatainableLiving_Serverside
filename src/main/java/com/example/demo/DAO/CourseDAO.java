package com.example.demo.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Repository.CourseRepository;
import com.example.demo.model.Courses;

@Component
public class CourseDAO {
	
	@Autowired
	CourseRepository repo;
	
	public Courses addCourse(Courses courses)
	{
		repo.save(courses);
		return courses;
	}
	
	
	public List<Courses> getall()
	{
		return repo.findAll();
	}
	
	

	// Use the count method from JpaRepository to get the count of courses
	public long count() {
		return repo.count();  // This uses the built-in count() method of JpaRepository
	}
}
