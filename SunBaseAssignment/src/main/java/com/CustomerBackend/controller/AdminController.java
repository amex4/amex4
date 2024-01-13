package com.CustomerBackend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerBackend.model.AdminUser;
import com.CustomerBackend.util.JwtUtil;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class AdminController {
	
	@Autowired
	private final AuthenticationManager authenticationManager;
	
	private JwtUtil jwtUtil;
	
	public AdminController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
		 this.authenticationManager = authenticationManager;
	     this.jwtUtil = jwtUtil;		
	}
	
	// call the login method to use authentication which works with customUserService
	
	@PostMapping("/auth/login")
	public ResponseEntity<Object> login(@RequestBody AdminUser user) {
		try {
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
			
			String email = authentication.getName();
			AdminUser tempUser = new AdminUser(email, "");
			String token = jwtUtil.createToken(tempUser);
			
			Map<String, String> response = new HashMap<>();
			response.put("token", token);
			return ResponseEntity.ok(response);
		} catch (BadCredentialsException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("inavlid username or password");
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
