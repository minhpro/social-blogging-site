package com.example.socialbloggingsite.application.user;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@JsonRootName("user")
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterParam {
	@NotBlank(message = "can't be empty")
	@Email(message = "should be an email")
	@DuplicatedEmailConstraint
	private String email;

	@NotBlank(message = "can't be empty")
	@DuplicatedUsernameConstraint
	private String username;

	@NotBlank(message = "can't be empty")
	private String password;
}