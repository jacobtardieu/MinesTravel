package org.springframework.samples.travel.interfaces.web.controller;

import javax.inject.Inject;

import org.springframework.samples.travel.application.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    public void profile(@PathVariable String id) {
    	
    }
}
