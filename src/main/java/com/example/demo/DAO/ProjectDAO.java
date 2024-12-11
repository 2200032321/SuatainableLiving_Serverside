package com.example.demo.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Repository.ProjectRepository;
import com.example.demo.model.Projects;
import java.util.*;
@Component
public class ProjectDAO {
	
	@Autowired
	ProjectRepository repo;
	
	public void saveProject(Projects projects)
	{
		repo.save(projects);
	}
	
	public Projects findProject(String name)
	{
		return repo.findByName(name);
	}
	
	public List<Projects> viewProjects()
	{
		return repo.findAll();
	}

	public void deleteProject(String name)
	{
		repo.delete(findProject(name));
	}
	public void UpdateProject(String name)
	{
		Projects project=findProject(name);
		repo.delete(findProject(name));
		repo.save(project);
	}

	public long count() {
		// TODO Auto-generated method stub
		return repo.count();
	}
}  