package org.springframework.samples.travel.application.impl;

import org.springframework.samples.travel.application.UserService;
import org.springframework.samples.travel.domain.model.user.User;
import org.springframework.samples.travel.domain.model.user.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Service dealing with users
 * Created by Lucas on 04/02/2014.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Inject
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}
}
