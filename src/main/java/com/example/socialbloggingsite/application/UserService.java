package com.example.socialbloggingsite.application;

import com.example.socialbloggingsite.application.user.UserData;
import com.example.socialbloggingsite.application.user.UserRegisterParam;
import com.example.socialbloggingsite.core.user.EncryptService;
import com.example.socialbloggingsite.core.user.User;
import com.example.socialbloggingsite.core.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class UserService {
	private UserRepository userRepository;
	private EncryptService encryptService;

	@Autowired
	public UserService(UserRepository userRepository, EncryptService encryptService) {
		this.userRepository = userRepository;
		this.encryptService = encryptService;
	}

	public UserData createUser(@Valid UserRegisterParam registerParam) {
		User user =
				new User(
						registerParam.getEmail(),
						registerParam.getUsername(),
						encryptService.encryptPassword(registerParam.getPassword()),
						"",
						"");
		userRepository.save(user);
		return UserData.fromUser(user);
	}

	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
