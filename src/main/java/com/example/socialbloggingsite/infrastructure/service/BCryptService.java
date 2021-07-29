package com.example.socialbloggingsite.infrastructure.service;

import com.example.socialbloggingsite.core.user.EncryptService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BCryptService implements EncryptService {
	private BCryptPasswordEncoder passwordEncoder;

	public BCryptService() {
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	@Override
	public String encryptPassword(String plainPassword) {
		return passwordEncoder.encode(plainPassword);
	}

	@Override
	public boolean checkPassword(String checkPassword, String encryptedPassword) {
		return passwordEncoder.matches(checkPassword, encryptedPassword);
	}
}
