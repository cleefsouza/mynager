package com.mynager.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mynager.rest.api.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	// find user by email
	User findByEmail(String email);
	
	// find user by id
	User findById(long id);
}
