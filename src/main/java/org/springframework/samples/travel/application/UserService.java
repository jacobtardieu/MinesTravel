package org.springframework.samples.travel.application;

import org.springframework.samples.travel.domain.model.user.User;

/**
 * Service concerning user reigstery
 * Created by Lucas on 04/02/2014.
 */
public interface UserService {

	/**
	 * Save an user into repository
	 * @param user the user to save
	 * @return the user saved
	 */
	User saveUser (User user);

	/**
	 * Find an user by its username
	 *
	 * @param username
	 * The username to search for
	 * @return The user associated with the given username, <code>null</code>
	 *         otherwise.
	 */
	User findByUsername(String username);

    User createUser();
}
