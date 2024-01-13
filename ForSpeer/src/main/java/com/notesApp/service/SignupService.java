package com.notesApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notesApp.model.UserDetails;
import com.notesApp.repository.UserRepository;

@Service
public class SignupService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public boolean signup(UserDetails user) {
		try {
			userRepository.save(user);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

}
