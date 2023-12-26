package com.khan.security.controllers;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.khan.security.model.Role;
import com.khan.security.model.User;
import com.khan.security.repository.UserRepo;
import com.khan.security.securityImpl.SecurityService;

@Controller
public class UserController {

	@Autowired
	private SecurityService securityService;
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder encoder;

	@GetMapping("/showReg")
	public String showRegistrationPage() {
		return "registerUser";
	}

	@PostMapping("/registerUser")
	public String register(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		HashSet<Role> roles = new HashSet<>();
		Role role = new Role();
		role.setId(1l);//here we set the role id according to sql Database
		// 1 is admin and 2 is user.
		roles.add(role);
		user.setRoles(roles);
		userRepo.save(user);
		return "login";
	}

	@GetMapping("/")
	public String showLoginPage() {
		return "login";
	}

	@PostMapping("/login")
	public String login(String email, String password) {
		boolean loginResponse = securityService.login(email, password);
		if (loginResponse) {
			return "index";
		}
		return "login";

	}

}
