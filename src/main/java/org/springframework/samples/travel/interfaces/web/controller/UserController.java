package org.springframework.samples.travel.interfaces.web.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by calixtebonsart on 04/02/14.
 */
@Controller
public class UserController {

	@Inject
	public UserController() {
		// TODO user model
	}
	
    @RequestMapping(value = "/users/signup", method = RequestMethod.GET)
    public String signup() {
        return "users/signup";
    }
    
    @RequestMapping(value = "/users/profile", method = RequestMethod.GET)
    public String profile(@PathVariable String id) {
    	return "/users/profile";
    }
}
