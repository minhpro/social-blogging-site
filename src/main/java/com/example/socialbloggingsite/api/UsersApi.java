package com.example.socialbloggingsite.api;

import com.example.socialbloggingsite.api.exception.InvalidAuthenticationException;
import com.example.socialbloggingsite.application.user.UserData;
import com.example.socialbloggingsite.application.user.UserRegisterParam;
import com.example.socialbloggingsite.application.UserService;
import com.example.socialbloggingsite.core.service.TokenService;
import com.example.socialbloggingsite.core.user.EncryptService;
import com.example.socialbloggingsite.core.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

@RestController
public class UsersApi {
	private UserService userService;
	private EncryptService encryptService;
	private TokenService tokenService;

	@Autowired
	public UsersApi(UserService userService, EncryptService encryptService, TokenService tokenService) {
		this.userService = userService;
		this.encryptService = encryptService;
		this.tokenService = tokenService;
	}

	@PostMapping("/users")
	@ResponseBody
	public UserData createUser(@Valid @RequestBody UserRegisterParam registerParam) {
		return userService.createUser(registerParam);
	}

	@PostMapping("/users/login")
	@ResponseBody
	public LoginResponse login(@Valid @RequestBody LoginParam loginParam)
			throws InvalidAuthenticationException {
		Optional<User> optional = userService.findByEmail(loginParam.getEmail());
		if (optional.isPresent()
				&& encryptService.checkPassword(loginParam.getPassword(), optional.get().getPassword())) {
			User user = optional.get();
			UserData userData = UserData.fromUser(user);
			return new LoginResponse(tokenService.generateToken(user), userData);
		} else {
			throw new InvalidAuthenticationException();
		}
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

@Getter
@AllArgsConstructor
class LoginResponse {
	private String token;
	private UserData user;
}
