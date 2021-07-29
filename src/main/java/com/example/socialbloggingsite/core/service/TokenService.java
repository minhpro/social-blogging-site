package com.example.socialbloggingsite.core.service;

import com.example.socialbloggingsite.core.user.User;

import java.util.Optional;

public interface TokenService {
	String generateToken(User user);

	Optional<String> getSubFromToken(String token);
}
