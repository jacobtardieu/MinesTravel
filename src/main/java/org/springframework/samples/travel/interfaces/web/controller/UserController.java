package org.springframework.samples.travel.interfaces.web.controller;

import java.security.Principal;
import java.util.List;

import javax.inject.Inject;

import org.springframework.samples.travel.application.UserService;
import org.springframework.samples.travel.domain.model.user.User;
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
    public void list(Model model, Principal user) {
    	if (user != null)
    		System.out.println("AAAAAAAAAAAAAAAAA " + user);
        List<User> users = userService.findAllUsers();
        model.addAttribute("userList", users);
    }
}
