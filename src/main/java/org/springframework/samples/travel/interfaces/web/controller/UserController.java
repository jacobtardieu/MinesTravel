package org.springframework.samples.travel.interfaces.web.controller;

import java.security.Principal;
import java.util.List;

import javax.inject.Inject;

import org.springframework.samples.travel.application.UserService;
import org.springframework.samples.travel.domain.model.user.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * Created by calixtebonsart on 04/02/14.
 */
@Controller
public class UserController {
    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users/profile", method = RequestMethod.GET)
    public String profile(Principal user) {
    	if (user != null) {
    		return "users/profile";
    	} else {
    		return "users/login";
    	}
    }
    
    @RequestMapping(value = "/users/admin", method = RequestMethod.GET)
    public String list(Model model, Principal user) {
    	if (user != null && ((UsernamePasswordAuthenticationToken)user).getAuthorities().contains(new SimpleGrantedAuthority("ROLE_SUPERVISOR"))) {
//    		System.out.println("AAAAAAAAAAAAAAAAA " + user);
//    		System.out.println("AAAAAAAAAAAAAAAAA " + user.getClass());
//    		System.out.println(((UsernamePasswordAuthenticationToken)user).getAuthorities());
//    		System.out.println(((UsernamePasswordAuthenticationToken)user).getAuthorities().contains(new SimpleGrantedAuthority("ROLE_SUPERVISOR")));
    		List<User> users = userService.findAllUsers();
            model.addAttribute("userList", users);
            return "users/admin";
    	} else {
    		return "home";
    	}
    }
}
