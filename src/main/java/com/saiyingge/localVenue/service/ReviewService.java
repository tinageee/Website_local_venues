package com.saiyingge.localVenue.service;

import com.saiyingge.localVenue.dto.ReviewDTO;
import com.saiyingge.localVenue.entity.Review;

import java.util.List;

public interface ReviewService {
    public void saveReview(ReviewDTO reviewDTO);
    public List<Review> getAllReviews();

    List<Review> getReviewByUserId(int userId);

    List<ReviewDTO>  getReviewByVenueID(int id);




}
