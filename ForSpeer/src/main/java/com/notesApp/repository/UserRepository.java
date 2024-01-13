package com.notesApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notesApp.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer>{
	
	UserDetails findByUsername(String username);
}
