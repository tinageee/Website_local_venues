package com.saiyingge.localVenue.serviceTest;

import com.saiyingge.localVenue.dto.ReviewDTO;
import com.saiyingge.localVenue.dto.UserDTO;
import com.saiyingge.localVenue.entity.Review;
import com.saiyingge.localVenue.entity.User;
import com.saiyingge.localVenue.repository.ReviewRepository;
import com.saiyingge.localVenue.service.ReviewService;
import com.saiyingge.localVenue.service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// Import your Review and UserService classes

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReviewServiceWithDBTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserService userService;

    private ReviewService reviewService;

    @BeforeEach
    public void init() {

//        UserDTO user = new UserDTO();
//        user.setId(1L);

        ReviewDTO review1 = new ReviewDTO();
        review1.setUserId(1L);
        review1.setContent("Review 1 Content");

        ReviewDTO review2 = new ReviewDTO();
        review1.setUserId(1L);
        review2.setContent("Review 2 Content");


//        userService.saveUser(user);
        reviewService.saveReview(review1);
        reviewService.saveReview(review2);

    }

    @Test
    public void testGetReviewsByUserId() {
        // Call the ReviewService method to get reviews by user ID
        List<Review> actualReviews = reviewService.getReviewByUserId(1);

        // Assert that the actual reviews match the expected reviews
        assertEquals(2, actualReviews.size());
    }
}
