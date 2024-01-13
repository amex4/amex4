package com.CustomerBackend.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.CustomerBackend.model.AdminUser;
import com.CustomerBackend.repository.AdminUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private final AdminUserRepository userRepository;
	
	public CustomUserDetailsService (AdminUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		AdminUser user = userRepository.findByEmail(email);
		List<String> roles = new ArrayList<>();
		roles.add("USER");
		UserDetails userDetails = User.builder()
								  .username(user.getEmail())
								  .password(user.getPassword())
								  .roles(roles.toArray(new String[0]))
								  .build();
		return userDetails;
	}
}
