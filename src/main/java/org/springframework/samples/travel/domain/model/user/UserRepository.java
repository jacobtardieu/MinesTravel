package org.springframework.samples.travel.domain.model.user;

import java.util.List;

/**
 * Repository for {@linkplain User}
 */
public interface UserRepository {

    /**
     * Find an user by its username
     * 
     * @param username
     *            The username to search for
     * @return The user associated with the given username, <code>null</code>
     *         otherwise.
     */
    User findByUsername(String username);

	/**
	 * Save an user into repository
	 * @param user the user to save
	 * @return the user saved
	 */
	User save(User user);

	List<User> findAll();

	void deleteByUsername(String userName);
}
