package com.saiyingge.localVenue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * a Spring MVC controller that handles requests for the root path ("/"), login page ("/login"), and contact us page ("/contactUs"),
 * returning the corresponding Thymeleaf templates for each URL.
 *
 * @author S.G
 */
@Controller
public class LoginController {


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/contactUs")
    public String contactUs() {
        return "contactUs"; // This should match the name of your Thymeleaf template for the contact page
    }


}
