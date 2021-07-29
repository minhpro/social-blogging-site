package com.example.soicialbloggingsite.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@RestController
public class UsersApi {

	@GetMapping("/")
	public String index() {
		return "Hello!";
	}

	public ResponseEn

	@PostMapping("/login")
	public String login(@Valid @RequestBody LoginParam loginParam) {
		return "Hello!";
	}
}

@Getter
@NoArgsConstructor
class LoginParam {
	@NotBlank(message = "can't be empty")
	@Email(message = "should be an email")
	private String email;

	@NotBlank(message = "can't be empty")
	private String password;
}
