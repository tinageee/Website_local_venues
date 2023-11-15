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
//    @GetMapping("/account")
//    public String account(Model model) {
//        model.addAttribute("reviewList", Arrays.asList("Review 1", "Review 2", "Review 3"));
//        return "account";
//    }

//    @GetMapping("/account")
//    public String account(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentUserName = authentication.getName();
//        // Assuming the username is the user's ID
//        // You might need to modify this part to suit how your user identification is set up
//        int userId = Integer.parseInt(currentUserName);
//
//        model.addAttribute("review-list", reviewService.getReviewByUserId(userId));
//
//        return "account";
//    }
}
