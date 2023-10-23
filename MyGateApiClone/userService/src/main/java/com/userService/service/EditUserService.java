package com.userService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.userService.dao.UserRepository;
import com.userService.model.User;

@Component
public class EditUserService {
	
	@Autowired
	private UserRepository repository;
	
	
	public boolean editUserService(User user) {
		try {
		repository.save(user);
		return true;
		}
		catch (Exception e) {
			return false;
		}
	}
}
