package com.saiyingge.localVenue.controller;

import com.saiyingge.localVenue.dto.ReviewDTO;
import com.saiyingge.localVenue.dto.VenueDTO;
import com.saiyingge.localVenue.entity.Review;
import com.saiyingge.localVenue.entity.User;
import com.saiyingge.localVenue.service.ReviewServiceImpl;
import com.saiyingge.localVenue.entity.Venue;
import com.saiyingge.localVenue.service.UserServiceImpl;
import com.saiyingge.localVenue.service.VenueServiceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;


@Controller
public class VenueController {

    @Autowired
    private VenueServiceImpl venueService;

    @Autowired
    private ReviewServiceImpl reviewService;

    @Autowired
    private UserServiceImpl userService;



    @GetMapping("/venueList")
    public String listVenues(Model model) {
        List<Venue> venues = venueService.getAllVenues();
        System.out.println("Venues: " + venues); // Logging for debugging
        model.addAttribute("venues", venues);

        return "venueList"; // name of the Thymeleaf template
    }

    @GetMapping("/venues/{id}")
    public String showVenue(@PathVariable("id") Long id, Model model, Principal principal) {
        VenueDTO venue = venueService.getVenueById(id);  // Assuming you have such a method in your service
        model.addAttribute("venue", venue);
        List<Review> reviews = reviewService.getReviewByVenueID(id);
        model.addAttribute("reviews", reviews);
        model.addAttribute("isLoggedIn", principal != null); // Check if the user is logged in
        return "venuePage";  // Name of the Thymeleaf template for showing venue details
    }
    @PostMapping("/submitVenueReview")
    public String submitVenueReview(@RequestParam("venueId") Long venueId,
                               @RequestParam("content") String content,
                               @RequestParam("rating") Integer rating,
                               Principal principal,
                               RedirectAttributes redirectAttributes) {
        if (principal != null) {
            if (content == null || content.trim().isEmpty() || rating == null) {
                // Handle the case where content or rating is null
                redirectAttributes.addFlashAttribute("error", "Content and rating must be provided.");
                return "redirect:/venues/" + venueId;
            }

            // Implement logic to save the review
            String email = principal.getName();
            User user= userService.findUserByEmailForSecurity(email);

            ReviewDTO reviewDTO = new ReviewDTO();
            reviewDTO.setVenueId(venueId);
            reviewDTO.setUserId(user.getId());
            reviewDTO.setContent(content);
            reviewDTO.setRating(rating);

            reviewService.saveReview(reviewDTO);
        }
        return "redirect:/venues/" + venueId;
    }

}
