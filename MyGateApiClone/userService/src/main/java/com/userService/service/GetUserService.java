package com.userService.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.userService.dao.UserRepository;

import com.userService.model.User;

@Component
public class GetUserService {

	@Autowired
	private UserRepository repository;
	
	
	public User getUser(String username) {
		try {
			return repository.findByUsername(username);
		}
		catch (Exception e) {
			return null;
		}
	}
	
	public User getUserByFlat(String houseNumber) {
		try {
			return repository.findByHouseNumber(houseNumber);
		}
		catch (Exception e) {
			return null;
		}
	}
}
