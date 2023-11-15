package com.saiyingge.localVenue.repositoryTest;


import com.saiyingge.localVenue.dto.ReviewDTO;
import com.saiyingge.localVenue.entity.Review;
import com.saiyingge.localVenue.entity.User;
import com.saiyingge.localVenue.entity.Venue;
import com.saiyingge.localVenue.entity.Vendor;


import com.saiyingge.localVenue.repository.ReviewRepository;
import com.saiyingge.localVenue.repository.UserRepository;
import com.saiyingge.localVenue.repository.VendorRepository;
import com.saiyingge.localVenue.repository.VenueRepository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private VendorRepository vendorRepository;


    Review review1;
    Review review2;


    @BeforeEach
    public void init() {
        User user;
        Venue venue;
        Vendor vendor;

        user = new User();
        user.setEmail("test@test.com");
        user.setPassword("12123232");
        user.setFirstName("Igor");
        user.setLastName("Adulyan");
        user.setPhoneNumber("818-987-1234");


        venue = new Venue();
        venue.setName("Test Venue");
        venue.setLocation("123 Main st");

        vendor = new Vendor();
        vendor.setName("Test Vendor");
        vendor.setDescription("123 Main st");

        userRepository.save(user);
        venueRepository.save(venue);
        vendorRepository.save(vendor);

        review1 = new Review();
        review1.setContent("This is a test review, on a venue.");
        review1.setRating(5);
        review1.setUser(user);
        review1.setVenue(venue);



        review2 = new Review();
        review2.setContent("This is 2nd test review, on a vendor.");
        review2.setRating(4);
        review2.setUser(user);
        review2.setVendor(vendor);


    }

    @Test
    public void testSaveReview1() {

        // Save the review using the repository
        reviewRepository.save(review1);

        // Retrieve the saved review
        Review savedReview = reviewRepository.findById(review1.getId()).orElse(null);

        // Assert that the saved review is not null
        Assertions.assertNotNull(savedReview);

        // Add more assertions as needed to verify the saved review's properties
        Assertions.assertEquals("This is a test review, on a venue.", savedReview.getContent());
        Assertions.assertEquals(5, savedReview.getRating());
    }

    @Test
    public void testSaveReview2() {

        // Save the review using the repository
        reviewRepository.save(review2);

        // Retrieve the saved review
        Review savedReview = reviewRepository.findById(review2.getId()).orElse(null);

        // Assert that the saved review is not null
        Assertions.assertNotNull(savedReview);

        // Add more assertions as needed to verify the saved review's properties
        Assertions.assertEquals("This is 2nd test review, on a vendor.", savedReview.getContent());
        Assertions.assertEquals(4, savedReview.getRating());
    }

    @Test
    public void testFindByVenueId1() {
        reviewRepository.save(review1);
        reviewRepository.save(review2);
//        // Assuming you have saved reviews associated with a specific venue, you can test findByVenueId here
        List<Review> reviewsForVenue = reviewRepository.findByVenueId(review1.getVenue().getId());
//
//        // Assert that the returned list of reviews is not null and contains the expected number of reviews
//
        Assertions.assertNotNull(reviewsForVenue);
        Assertions.assertEquals(1, reviewsForVenue.size()); //  expectedNumberOfReviews is 1

        // Print out the venueId and the associated reviews
        System.out.println("Venue ID: " + review1.getVenue().getId());
        for (Review review : reviewsForVenue) {
            System.out.println("Review ID: " + review.getId());
            System.out.println("Review Content: " + review.getContent());
            // You can print more review properties as needed
            System.out.println("----------------------------------------");
        }
    }

    @Test
    public void testFindByVenueId2() {
        reviewRepository.save(review1);
        reviewRepository.save(review2);

        Venue testVenue=review1.getVenue();

        Review review3 = new Review();
        review3.setContent("This is 3nd test review, on a vendor.");
        review3.setRating(3);
        review3.setUser(review1.getUser());
        review3.setVenue(testVenue);
        reviewRepository.save(review3);

//        // Assuming you have saved reviews associated with a specific venue, you can test findByVenueId here
        List<Review> reviewsForVenue = reviewRepository.findByVenueId(testVenue.getId());
//
//        // Assert that the returned list of reviews is not null and contains the expected number of reviews
//
        Assertions.assertNotNull(reviewsForVenue);
        Assertions.assertEquals(2, reviewsForVenue.size()); //  expectedNumberOfReviews should be 2

        // Print out the venueId and the associated reviews
        System.out.println("Venue ID: " + testVenue.getId());
        for (Review review : reviewsForVenue) {
            System.out.println("Review ID: " + review.getId());
            System.out.println("Review Content: " + review.getContent());
            // You can print more review properties as needed
            System.out.println("----------------------------------------");
        }
    }

    @Test
    public void testFindByVendorId() {
        reviewRepository.save(review1);
        reviewRepository.save(review2);

        List<Review> reviewsForVendor = reviewRepository.findByVendorId(review2.getVendor().getId());
        Assertions.assertNotNull(reviewsForVendor);
        Assertions.assertEquals(1, reviewsForVendor.size()); // Replace expectedNumberOfReviews is 1

        System.out.println("Vendor ID: " + review2.getVendor().getId());
        for (Review review : reviewsForVendor) {
            System.out.println("Review ID: " + review.getId());
            System.out.println("Review Content: " + review.getContent());
            // You can print more review properties as needed
            System.out.println("----------------------------------------");
        }
    }


    @Test
    public void testFindByUserId() {
        reviewRepository.save(review1);
        reviewRepository.save(review2);

        List<Review> reviewsForUser = reviewRepository.findByUserId(review1.getUser().getId());
        Assertions.assertNotNull(reviewsForUser);
        Assertions.assertEquals(2, reviewsForUser.size()); // Replace expectedNumberOfReviews is 1

        System.out.println("User ID: " + review1.getUser().getId());
        for (Review review : reviewsForUser) {
            System.out.println("Review ID: " + review.getId());
            System.out.println("Review Content: " + review.getContent());
            // You can print more review properties as needed
            System.out.println("----------------------------------------");
        }
    }
}
