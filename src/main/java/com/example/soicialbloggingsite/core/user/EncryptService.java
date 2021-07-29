package com.example.soicialbloggingsite.core.user;

import org.springframework.stereotype.Service;

@Service
public interface EncryptService {
	String encryptPassword(String plainPassword);

	boolean checkPassword(String checkPassword, String encryptedPassword);
}
