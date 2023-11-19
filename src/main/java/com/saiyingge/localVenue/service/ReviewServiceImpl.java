package com.saiyingge.localVenue.service;

import com.saiyingge.localVenue.dto.ReviewDTO;
import com.saiyingge.localVenue.entity.Review;
import com.saiyingge.localVenue.entity.User;
import com.saiyingge.localVenue.entity.Vendor;
import com.saiyingge.localVenue.entity.Venue;
import com.saiyingge.localVenue.repository.ReviewRepository;
import com.saiyingge.localVenue.repository.UserRepository;
import com.saiyingge.localVenue.repository.VendorRepository;
import com.saiyingge.localVenue.repository.VenueRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final VenueRepository venueRepository;
    private final VendorRepository vendorRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository,
                             UserRepository userRepository,
                             VenueRepository venueRepository,
                             VendorRepository vendorRepository,
                             ModelMapper modelMapper) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.venueRepository = venueRepository;
        this.vendorRepository = vendorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public void saveReview(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setContent(reviewDTO.getContent());
        review.setRating(reviewDTO.getRating());

        // Fetch and set User, Venue, and Vendor entities

        User user = userRepository.findById(reviewDTO.getUserId()).orElse(null);
        Venue venue = venueRepository.findById(reviewDTO.getVenueId()).orElse(null);
        Vendor vendor = vendorRepository.findById(reviewDTO.getVendorId()).orElse(null);

        review.setUser(user);
        review.setVenue(venue);
        review.setVendor(vendor);

        reviewRepository.save(review);
    }


    @Override
    @Transactional
    public List<Review> getAllReviews() {
        return (List<Review>) reviewRepository.findAll();
    }


    @Override
    @Transactional
    public List<Review> getReviewByUserId(long userId) {
        return reviewRepository.findByUserId(userId);
    }

    @Override
    public List<Review> getReviewByVenueID(long venueId) {
        return reviewRepository.findByVenueId(venueId);
    }
    @Override
    public List<Review> getReviewByVendorId(long vendorId) {
        return reviewRepository.findByVendorId(vendorId);
    }


    public void deleteReview(long reviewId) {
        reviewRepository.deleteById(reviewId);

    }
}
