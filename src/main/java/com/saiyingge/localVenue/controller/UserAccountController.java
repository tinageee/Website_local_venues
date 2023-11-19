package com.saiyingge.localVenue.controller;


import com.saiyingge.localVenue.entity.Review;
import com.saiyingge.localVenue.entity.User;
import com.saiyingge.localVenue.service.ReviewServiceImpl;
import com.saiyingge.localVenue.service.UserServiceImpl;
import com.saiyingge.localVenue.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Controller
public class UserAccountController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ReviewServiceImpl reviewService;



    @GetMapping("/account/{id}")
    public String showUserReviews(@PathVariable("id") Long id, Model model)
    {
        Optional<User> userInfoOptional = userService.findById(id);
        User userInfo = userInfoOptional.orElse(null);
        model.addAttribute("userInfo", userInfo);
        List<Review> reviews = reviewService.getReviewByUserId(id);
        model.addAttribute("reviewList", reviews);

        return "userAccount";
    }

}
