package com.userService.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.userService.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	public User findByUsername(String username);
	public User findByHouseNumber(String houseNumber);
}
