package org.springframework.samples.travel.interfaces.web.controller;

import org.springframework.samples.travel.domain.model.booking.Booking;
import org.springframework.samples.travel.domain.shared.SearchCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

/**
 * Created by calixtebonsart on 04/02/14.
 */
@Controller
public class UserController {

    @RequestMapping(value = "/users/signup", method = RequestMethod.GET)
    public void signup() {

    }
}
