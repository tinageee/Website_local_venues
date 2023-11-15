package com.saiyingge.localVenue.service;

import com.saiyingge.localVenue.dto.ReviewDTO;
import com.saiyingge.localVenue.entity.Review;
import com.saiyingge.localVenue.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
        this.modelMapper = modelMapper;
    }

    @Override

    public void saveReview(ReviewDTO reviewDTO) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Review review  = modelMapper.map(reviewDTO, Review.class);

        reviewRepository.save(review);
    }


    @Override
    @Transactional
    public List<Review> getAllReviews() {
        return (List<Review>) reviewRepository.findAll();
    }


    @Override
    @Transactional
    public List<Review> getReviewByUserId(int userId) {
        return reviewRepository.findByUserId(userId);
    }

    @Override
    public List<Review> getReviewByVenueID(int venueId) {
        return reviewRepository.findByVenueId(venueId);
    }
    @Override
    public List<Review> getReviewByVendorId(int vendorId) {
        return reviewRepository.findByVendorId(vendorId);
    }

    //    @Override
//    public ReviewDTO updateReview(ReviewDTO reviewDTO, Long id) {
//        Review existingReview = reviewRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Review not found for id: " + id));
//
//        // Update properties of existingReview with those from reviewDTO
//        // For example:
//        // existingReview.setContent(reviewDTO.getContent());
//        // Add other properties as needed
//
//        existingReview = reviewRepository.save(existingReview);
//        return convertToDto(existingReview);
//    }

//    @Override
//    public void deleteReview(Long id) {
//        reviewRepository.deleteById(id);
//    }

    // Helper method to convert Review entity to ReviewDTO
//    private ReviewDTO convertToDto(Review review) {
//        ReviewDTO reviewDTO = new ReviewDTO();
//        // Map fields from Review to ReviewDTO
//         reviewDTO.setId(review.getId());
//
//        return reviewDTO;
//    }

}
