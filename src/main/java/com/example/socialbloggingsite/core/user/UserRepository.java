package com.example.socialbloggingsite.core.user;

import java.util.Optional;

public interface UserRepository {
	void save(User user);

	Optional<User> findById(String id);

	Optional<User> findByUsername(String username);

	Optional<User> findByEmail(String email);
}
