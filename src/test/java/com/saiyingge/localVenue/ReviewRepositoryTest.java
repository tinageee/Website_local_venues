package com.saiyingge.localVenue;


import com.saiyingge.localVenue.entity.Review;
import com.saiyingge.localVenue.entity.User;
import com.saiyingge.localVenue.repository.ReviewRepository;
import com.saiyingge.localVenue.repository.UserRepository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

     Review review;
     Review review2;
    @BeforeEach
    public void init() {
        User user = new User(); // Replace User with the actual user creation logic
        user.setEmail("test@example.com"); // Set user properties as needed
        user.setUsername("testuser");
        userRepository.save(user);


        review = new Review();
        review.setContent("This is a test review.");
        review.setRating(5);
        review.setUser(user);


        review2 = new Review();
        review2.setContent("This is 2nd test review.");
        review2.setRating(4);
        review2.setUser(user);

    }

    @Test
    public void testSaveReview() {

        // Save the review using the repository
        reviewRepository.save(review);

        // Retrieve the saved review
        Review savedReview = reviewRepository.findById(review.getId()).orElse(null);

        // Assert that the saved review is not null
        Assertions.assertNotNull(savedReview);

        // Add more assertions as needed to verify the saved review's properties
        Assertions.assertEquals("This is a test review.", savedReview.getContent());
        Assertions.assertEquals(5, savedReview.getRating());
    }

    // Add more test methods as needed to cover various repository operations

}
