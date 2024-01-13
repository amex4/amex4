package com.notesApp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.notesApp.model.UserDetails;
import com.notesApp.service.SignupService;


@RestController
public class SignupController {
	
	@Autowired
	private SignupService signupService;
	
	//method for registering a user
	
	@PostMapping("api/auth/signup")
	public Map<String, Object> signup(@RequestBody UserDetails user) {
		
		// to send data in form of json
		Map<String, Object> response = new HashMap<>();
		
		response.put("success", signupService.signup(user));
		response.put("data", user);
		
		return response;
		
	}
}
