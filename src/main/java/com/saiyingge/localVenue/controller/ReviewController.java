//package com.saiyingge.localVenue.controller;
//
//import com.saiyingge.localVenue.dto.VenueDTO;
//import com.saiyingge.localVenue.entity.Review;
//import com.saiyingge.localVenue.service.ReviewService;
//import com.saiyingge.localVenue.service.ReviewServiceImpl;
//import com.saiyingge.localVenue.service.VenueService;
//import com.saiyingge.localVenue.entity.Venue;
//import com.saiyingge.localVenue.service.VenueServiceImpl;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//public class ReviewController {
//    @Autowired
//    private ReviewServiceImpl reviewService;
//    @PostMapping("/submitReview")
//    public String submitReview(@RequestParam("venueId") Long venueId,
//                               @RequestParam("content") String content,
//                               @RequestParam("rating") Integer rating,
//                               Principal principal) {
//        if (principal != null) {
//            // Logic to save review
//            // You can access the username with principal.getName() if needed
//        }
//        return "redirect:/venuesPage/" + venueId;
//    }
//
//}
