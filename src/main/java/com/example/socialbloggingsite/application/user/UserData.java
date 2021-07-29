package com.example.socialbloggingsite.application.user;

import com.example.socialbloggingsite.core.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserData {
	private String id;
	private String email;
	private String username;
	private String bio;
	private String image;

	public static UserData fromUser(User user) {
		return
				new UserData(
						user.getId(),
						user.getBio(),
						user.getEmail(),
						user.getImage(),
						user.getUsername());
	}
}
