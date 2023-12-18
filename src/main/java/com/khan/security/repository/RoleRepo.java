package com.khan.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khan.security.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

}
