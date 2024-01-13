package com.CustomerBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CustomerBackend.model.AdminUser;

public interface AdminUserRepository extends JpaRepository<AdminUser, String>{
	AdminUser findByEmail(String email);
}
