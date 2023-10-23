package com.userService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.userService.dao.UserRepository;
import com.userService.model.User;

@Component
public class UserRegistrationService {
	
	@Autowired
	private UserRepository repository;
	
	
	public boolean registerUser(User user) {
		if(!repository.existsById(user.getUsername())) {
			repository.save(user);
			return true;
		}
		else {
			return false;
		}
	}
}
