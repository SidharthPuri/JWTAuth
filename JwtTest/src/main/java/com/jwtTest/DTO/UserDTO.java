package com.jwtTest.DTO;

import com.jwtTest.entity.UserEntity;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

	
	private Long id;

	private String username;

	@NotNull
	private String email;

	private String password;

	private String firstName;

	private String lastName;

	public UserDTO(UserEntity user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.username = user.getUsername();
	}

}
