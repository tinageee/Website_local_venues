package com.saiyingge.localVenue.service;

import com.saiyingge.localVenue.dto.ReviewDTO;
import com.saiyingge.localVenue.entity.Review;
import com.saiyingge.localVenue.entity.Venue;
import com.saiyingge.localVenue.repository.ReviewRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<Review> getAllReviews() {
        return (List<Review>) reviewRepository.findAll();
    }


    @Override
    public ReviewDTO getReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found for id: " + id));
        return convertToDto(review);
    }

    @Override
    public List<ReviewDTO> getReviewByVenueID(int venueId) {
        List<Venue> review = reviewRepository.findByVenueId(venueId);
        return review.stream()
                .map(venue -> modelMapper.map(review, ReviewDTO.class))
                .collect(Collectors.toList());
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
    private ReviewDTO convertToDto(Review review) {
        ReviewDTO reviewDTO = new ReviewDTO();
        // Map fields from Review to ReviewDTO
         reviewDTO.setId(review.getId());

        return reviewDTO;
    }

}
