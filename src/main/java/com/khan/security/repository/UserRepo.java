package com.khan.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khan.security.model.User;

public interface UserRepo extends JpaRepository<User,Long> {
	User findByEmail(String email);
}
