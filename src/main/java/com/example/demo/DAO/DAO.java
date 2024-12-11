 package com.example.demo.DAO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.User;

@Component
public class DAO {
	
	@Autowired
	UserRepository repo;
	
	public void addUser(User user)
	{
		repo.save(user);
	}
	
	public User findUser(String email)
	{
		return repo.findByEmail(email);
	}
	 public Optional<User> loginUser(String email, String password) {
	        Optional<User> user = Optional.of(repo.findByEmail(email));
	        if (user.isPresent() && user.get().getPassword().equals(password)) {
	            return user;
	        }
	        return Optional.empty();
	    }

} 