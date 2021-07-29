package com.example.soicialbloggingsite.core.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class User {
	private String id;
	private String email;
	private String username;
	private String password;
	private String bio;
	private String image;

	public User(String email, String username, String password, String bio, String image) {
		this.id = UUID.randomUUID().toString();
		this.email = email;
		this.username = username;
		this.password = password;
		this.bio = bio;
		this.image = image;
	}
}
