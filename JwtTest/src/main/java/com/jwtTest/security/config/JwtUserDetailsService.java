package com.jwtTest.security.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwtTest.DTO.UserDTO;
import com.jwtTest.entity.UserEntity;
import com.jwtTest.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity user = userRepo.findByUsername(username);
		
		if (user==null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		} else {return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getHashPass(),
				new ArrayList<>());}
	}
	
	public UserDTO registerUser(UserDTO newUser) {
		UserEntity user = new UserEntity();
		user.setUsername(newUser.getUsername());
		user.setFirstName(newUser.getFirstName().toUpperCase());
		user.setLastName(newUser.getLastName().toUpperCase());
		user.setEmail(newUser.getEmail());
		user.setHashPass(encoder.encode(newUser.getPassword()));
		user = userRepo.save(user);
		return new  UserDTO(user);
	}
	

}