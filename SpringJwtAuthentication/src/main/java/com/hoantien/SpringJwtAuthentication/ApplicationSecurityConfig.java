package com.hoantien.SpringJwtAuthentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ApplicationSecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public A
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//  1) All request should be authenticated
		http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//	3) CSRF -> POST,PUT 
		http.csrf().disable();

		return http.build();
	}
}
