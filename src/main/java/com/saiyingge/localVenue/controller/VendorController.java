package com.saiyingge.localVenue.controller;

import com.saiyingge.localVenue.dto.ReviewDTO;
import com.saiyingge.localVenue.dto.VendorDTO;
import com.saiyingge.localVenue.entity.Review;
import com.saiyingge.localVenue.entity.User;
import com.saiyingge.localVenue.entity.Vendor;
import com.saiyingge.localVenue.service.ReviewServiceImpl;
import com.saiyingge.localVenue.service.UserServiceImpl;
import com.saiyingge.localVenue.service.VendorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

/**
 * provides endpoints for listing vendors ("/vendorList"), displaying vendor details ("/vendors/{id}"),
 * and submitting vendor reviews ("/submitVendorReview").
 *
 * @author S.G
 */

@Controller
public class VendorController {

    @Autowired
    private VendorServiceImpl vendorService;

    @Autowired
    private ReviewServiceImpl reviewService;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/vendorList")
    public String listVendors(Model model) {
        List<Vendor> vendors = vendorService.getAllVendors();
        System.out.println("Vendors: " + vendors); // Logging for debugging
        model.addAttribute("vendors", vendors);

        return "vendorList"; // name of the Thymeleaf template
    }

    @GetMapping("/vendors/{id}")
    public String showVendor(@PathVariable("id") Long id, Model model, Principal principal) {
        VendorDTO vendor = vendorService.getVendorById(id);  // Assuming you have such a method in your service
        model.addAttribute("vendor", vendor);
        List<Review> reviews = reviewService.getReviewByVendorId(id);
        model.addAttribute("reviews", reviews);

        model.addAttribute("isLoggedIn", principal != null); // Check if the user is logged in

        return "vendorPage";  // Name of the Thymeleaf template for showing vendor details
    }

    @PostMapping("/submitVendorReview")
    public String submitVendorReview(@RequestParam("vendorId") Long vendorId,
                                     @RequestParam("content") String content,
                                     @RequestParam("rating") Integer rating,
                                     Principal principal,
                                     RedirectAttributes redirectAttributes) {
        if (principal != null) {
//            if (content == null || content.trim().isEmpty() || rating == null) {
//                // Handle the case where content or rating is null
//                redirectAttributes.addFlashAttribute("error", "Content and rating must be provided.");
//                return "redirect:/vendors/" + vendorId;
//            }

            // Implement logic to save the review
            String email = principal.getName();
            User user = userService.findUserByEmailForSecurity(email);

            ReviewDTO reviewDTO = new ReviewDTO();
            reviewDTO.setVendorId(vendorId);
            reviewDTO.setUserId(user.getId());
            reviewDTO.setContent(content);
            reviewDTO.setRating(rating);

            reviewService.saveReview(reviewDTO);
        }
        return "redirect:/vendors/" + vendorId;
    }

}
