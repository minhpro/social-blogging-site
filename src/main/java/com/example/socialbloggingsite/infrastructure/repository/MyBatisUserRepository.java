package com.example.socialbloggingsite.infrastructure.repository;

import com.example.socialbloggingsite.core.user.User;
import com.example.socialbloggingsite.core.user.UserRepository;
import com.example.socialbloggingsite.infrastructure.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MyBatisUserRepository implements UserRepository {
	@Autowired
	private UserMapper userMapper;

	@Override
	public void save(User user) {
		userMapper.insert(user);
	}

	@Override
	public Optional<User> findById(String id) {
		User user = userMapper.findById(id);
		if (user != null)
			return Optional.of(user);
		return Optional.empty();
	}

	@Override
	public Optional<User> findByUsername(String username) {
		User user = userMapper.findByUsername(username);
		if (user != null)
			return Optional.of(user);
		return Optional.empty();
	}

	@Override
	public Optional<User> findByEmail(String email) {
		User user = userMapper.findByEmail(email);
		if (user != null)
			return Optional.of(user);
		return Optional.empty();
	}
}
