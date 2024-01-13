package com.notesApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.notesApp.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private final UserRepository userRepository;
	
	public CustomUserDetailsService (UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		com.notesApp.model.UserDetails user = userRepository.findByUsername(username);
		System.out.println(username+" "+user.getUsername());
		List<String> roles = new ArrayList<>();
		roles.add("USER");
		UserDetails userDetails = User.builder()
								  .username(user.getUsername())
								  .password(user.getPassword())
								  .roles(roles.toArray(new String[0]))
								  .build();
		return userDetails;
	}
	
	

}
