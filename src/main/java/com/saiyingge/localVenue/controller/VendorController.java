package com.saiyingge.localVenue.controller;

import com.saiyingge.localVenue.dto.VendorDTO;
import com.saiyingge.localVenue.entity.Review;
import com.saiyingge.localVenue.entity.Vendor;
import com.saiyingge.localVenue.service.ReviewServiceImpl;
import com.saiyingge.localVenue.service.VendorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class VendorController {

    @Autowired
    private VendorServiceImpl vendorService;

    @Autowired
    private ReviewServiceImpl reviewService;


    @GetMapping("/vendorsPage")
    public String listVendors(Model model) {
        List<Vendor> vendors = vendorService.getAllVendors();
        System.out.println("Vendors: " + vendors); // Logging for debugging
        model.addAttribute("vendors", vendors);

        return "vendors"; // name of the Thymeleaf template
    }

    @GetMapping("/vendors/{id}")
    public String showVendor(@PathVariable("id") Long id, Model model) {
        VendorDTO vendor = vendorService.getVendorById(id);  // Assuming you have such a method in your service
        model.addAttribute("vendor", vendor);
        List<Review> reviews = reviewService.getReviewByVendorId(id);
        model.addAttribute("reviews", reviews);
        return "vendorDetail";  // Name of the Thymeleaf template for showing vendor details
    }


}
