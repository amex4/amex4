package com.notesApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.notesApp.model.ErrorResponse;
import com.notesApp.model.LoginRequest;
import com.notesApp.model.LoginResponse;
import com.notesApp.model.UserDetails;
import com.notesApp.util.JwtUtil;

@RestController
public class LoginController {
	
	@Autowired
	private final AuthenticationManager authenticationManager;
	
	private JwtUtil jwtUtil;
	
	public LoginController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
		 this.authenticationManager = authenticationManager;
	     this.jwtUtil = jwtUtil;		
	}
	
	@PostMapping("api/auth/login")
	public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
		try {
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
			
			String username = authentication.getName();
			UserDetails user = new UserDetails(username, "");
			String token = jwtUtil.createToken(user);
			
			LoginResponse response = new LoginResponse(username,token);
			
			return ResponseEntity.ok(response);
		} catch (BadCredentialsException e) {
			ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST, "inavlid username or password");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		catch(Exception e) {
			ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

}
