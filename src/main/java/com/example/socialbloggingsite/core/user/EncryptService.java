package com.example.socialbloggingsite.core.user;

public interface EncryptService {
	String encryptPassword(String plainPassword);

	boolean checkPassword(String checkPassword, String encryptedPassword);
}
