package org.springframework.samples.travel.interfaces.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by calixtebonsart on 04/02/14.
 */
@Controller
public class UserController {

    @RequestMapping(value = "/users/signup", method = RequestMethod.GET)
    public void signup() {

    }
    
    @RequestMapping(value = "/users/profile", method = RequestMethod.GET)
    public void profile(@PathVariable String id, Model model) {
    	System.out.println("AAAAAAAAAAAAAAA");
    }
}
