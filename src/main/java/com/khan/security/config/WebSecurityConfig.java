package com.khan.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.authorizeHttpRequests()
		//Regex didn`t work because I am using old spring and java
		//it would work with requestMatchers
		.antMatchers(HttpMethod.GET, "/couponapi/coupons/{code:^[A-Z]*$}")
		.hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.POST,"/couponapi/coupons")
		.hasRole("ADMIN").and().csrf().disable();
		return http.build();
	}
}
