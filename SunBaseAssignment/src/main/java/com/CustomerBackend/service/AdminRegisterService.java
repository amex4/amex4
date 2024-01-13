package com.CustomerBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustomerBackend.model.AdminUser;
import com.CustomerBackend.repository.AdminUserRepository;

@Service
public class AdminRegisterService {
	
	@Autowired
	private AdminUserRepository adminUserRepository;
	
	public boolean register(AdminUser user){
		if (adminUserRepository.existsById(user.getEmail())) {
			return false;
		}
		else {
		adminUserRepository.save(user);
		return true;
		}
	}

}
