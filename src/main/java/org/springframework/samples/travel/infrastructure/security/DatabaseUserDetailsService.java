package org.springframework.samples.travel.infrastructure.security;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    	Logger log = (Logger) LoggerFactory.getLogger(DatabaseUserDetailsService.class);
        if (user == null)
            throw new UsernameNotFoundException("invalid username");
        
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
//		for (String role : user.getRoles()) {
			
//			roles.add(new SimpleGrantedAuthority(role));
//		}

        if (user.getUsername().equals("admin")) roles.add(new SimpleGrantedAuthority("ROLE_SUPERVISOR"));

		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
//		roles.add(new SimpleGrantedAuthority("ROLE_SUPERVISOR"));
//		Sets.newHashSet(new SimpleGrantedAuthority("ROLE_USER"))
        return new User(user.getUsername(), user.getPassword(), roles);
    }
}
