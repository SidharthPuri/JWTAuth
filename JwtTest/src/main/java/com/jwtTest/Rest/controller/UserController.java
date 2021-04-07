package com.jwtTest.Rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwtTest.DTO.UserDTO;
import com.jwtTest.security.config.JwtUserDetailsService;

@RestController
public class UserController {

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@PostMapping("/register")
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.registerUser(user));
	}
}
