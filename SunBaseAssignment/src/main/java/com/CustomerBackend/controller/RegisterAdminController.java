package com.CustomerBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerBackend.model.AdminUser;
import com.CustomerBackend.service.AdminRegisterService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class RegisterAdminController {

	@Autowired
	private AdminRegisterService adminRegisterService;
	
	@PostMapping("/auth/register")
	public ResponseEntity<Object> register(@RequestBody AdminUser user) {
		try {
			if(adminRegisterService.register(user)) {
				return ResponseEntity.ok(user);
			}
			else {
				throw new Exception();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("email Already exists");
		}
	}
}
