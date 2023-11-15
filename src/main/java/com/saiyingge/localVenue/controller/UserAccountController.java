package com.saiyingge.localVenue.controller;


import com.saiyingge.localVenue.service.UserService;
import com.saiyingge.localVenue.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Arrays;


@Controller
public class UserAccountController {

    private UserService userService;

    private ReviewService reviewService;

    @Autowired
    public UserAccountController(UserService userService, ReviewService reviewService) {
        this.userService = userService;
        this.reviewService = reviewService;
    }

    @GetMapping("/account")
    public String account(Model model)
    {
//        test with return all reviews
        model.addAttribute("reviewList", reviewService.getAllReviews());

        return "account";
    }

}
