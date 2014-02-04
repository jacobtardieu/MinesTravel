package org.springframework.samples.travel.application.impl;

import static com.google.common.collect.Lists.newArrayList;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.samples.travel.domain.model.booking.Booking;
import org.springframework.samples.travel.domain.model.user.User;
import org.springframework.samples.travel.domain.model.user.UserRepository;

@RunWith(MockitoJUnitRunner.class)

public class UserServiceImplTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImpl service;

	@Test
	public void shouldFindUserGivenAnUsername() {
		// Given
		String username = "username";
		User user = new User();
		when(userRepository.findByUsername(username)).thenReturn(user);

	}

	@Test
	public void shouldCreateUser() {
		// Given
		String username = "username";
		String password = "pass";

		User user = new User();
		User userToSave = new User(), expectedUser = new User();
		when(userRepository.save(userToSave)).thenReturn(expectedUser);

		// When
		User user1 =service.createUser(username, password, );

		// Then
		assertThat(user1).isSameAs(expectedUser);
	}

}
