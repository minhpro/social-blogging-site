package com.example.soicialbloggingsite.infrastructure.repository;

import com.example.soicialbloggingsite.core.user.User;
import com.example.soicialbloggingsite.core.user.UserRepository;

import java.util.Optional;

public class MyBatisUserRepository implements UserRepository {
	@Override
	public void save(User user) {

	}

	@Override
	public Optional<User> findById(String id) {
		return Optional.empty();
	}

	@Override
	public Optional<User> findByUsername(String username) {
		return Optional.empty();
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return Optional.empty();
	}
}
