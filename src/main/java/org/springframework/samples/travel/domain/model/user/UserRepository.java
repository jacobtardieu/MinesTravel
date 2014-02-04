package org.springframework.samples.travel.domain.model.user;

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
	
	/**
	 * Authentifiate an user
	 * @param username the username
	 * @param hashPassword the md5 hash of the password
	 * @return the user if exist else <code>null</code>
	 */
	User authentifiateUser(String username, String hashPassword);
}
