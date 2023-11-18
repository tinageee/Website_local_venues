package com.saiyingge.localVenue.controller;

import com.saiyingge.localVenue.dto.VenueDTO;
import com.saiyingge.localVenue.entity.Review;
import com.saiyingge.localVenue.service.ReviewService;
import com.saiyingge.localVenue.service.ReviewServiceImpl;
import com.saiyingge.localVenue.service.VenueService;
import com.saiyingge.localVenue.entity.Venue;
import com.saiyingge.localVenue.service.VenueServiceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VenueController {

    @Autowired
    private VenueServiceImpl venueService;

    @Autowired
    private ReviewServiceImpl reviewService;


    @GetMapping("/venuesPage")
    public String listVenues(Model model) {
        List<Venue> venues = venueService.getAllVenues();
        System.out.println("Venues: " + venues); // Logging for debugging
        model.addAttribute("venues", venues);

        return "venues"; // name of the Thymeleaf template
    }

    @GetMapping("/venues/{id}")
    public String showVenue(@PathVariable("id") Long id, Model model) {
        VenueDTO venue = venueService.getVenueById(id);  // Assuming you have such a method in your service
        model.addAttribute("venue", venue);
        List<Review> reviews = reviewService.getReviewByVenueID(id);
        model.addAttribute("reviews", reviews);
        return "venueDetail";  // Name of the Thymeleaf template for showing venue details
    }


}
