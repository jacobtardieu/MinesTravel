package org.springframework.samples.travel.infrastructure.security;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.samples.travel.domain.model.user.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * <p>
 * This class implements a in memory {@linkplain UserDetailsService}. Users are
 * stored in an internal map which key is the username. The map is statically
 * created and there is no way to add an user.
 * </p>
 * 
 * <p>
 * Available users are :
 * <ul>
 * <li>keith/melbourne</li>
 * <li>erwin/leuver</li>
 * <li>jeremy/atlanta</li>
 * <li>scott/rochester</li>
 * </ul>
 * </p>
 * 
 */
public class DatabaseUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Inject
	public DatabaseUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
    
    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetailsService#
     * loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	org.springframework.samples.travel.domain.model.user.User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("invalid username");
        }
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		for (String role : user.getRoles()) {
			roles.add(new SimpleGrantedAuthority(role));
		}
        UserDetails userDetails = new User(user.getName(), user.getPassword(), roles);
        return userDetails;
    }
}
