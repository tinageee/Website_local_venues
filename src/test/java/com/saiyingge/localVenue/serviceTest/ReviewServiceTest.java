package com.saiyingge.localVenue.serviceTest;
import com.saiyingge.localVenue.entity.Review;
import com.saiyingge.localVenue.repository.ReviewRepository;
import com.saiyingge.localVenue.repository.UserRepository;
import com.saiyingge.localVenue.repository.VenueRepository;
import com.saiyingge.localVenue.repository.VendorRepository;
import com.saiyingge.localVenue.service.ReviewServiceImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.*;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private VenueRepository venueRepository;

    @Mock
    private VendorRepository vendorRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ReviewServiceImpl reviewService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }




    @Test
    public void testGetAllReviews() {
        // Create a list of mock Review entities
        List<Review> mockReviews = new ArrayList<>();
        when(reviewRepository.findAll()).thenReturn(mockReviews);

        // Test the getAllReviews method
        List<Review> result = reviewService.getAllReviews();

        // Verify that the result matches the mockReviews
        assertEquals(mockReviews, result);
    }

    @Test
    @Transactional
    public void testGetReviewByUserId() {
        // Define a userId for testing
        long userId = 1L;

        // Create a list of expected Review objects
        List<Review> expectedReviews = List.of(
                new Review(/* Initialize with expected values */),
                new Review(/* Initialize with expected values */)
        );

        // Mock the behavior of reviewRepository.findByUserId(userId)
        when(reviewRepository.findByUserId(userId)).thenReturn(expectedReviews);

        // Call the method you want to test
        List<Review> actualReviews = reviewService.getReviewByUserId(userId);

        // Verify that reviewRepository.findByUserId(userId) was called with the expected userId
        verify(reviewRepository).findByUserId(userId);

        // Assert that the actual reviews match the expected reviews
        assertEquals(expectedReviews, actualReviews);
    }

    @Test
    @Transactional
    public void testDeleteReview() {
        // Prepare a reviewId for testing
        long reviewIdToDelete = 123L;

        // Mock the behavior of reviewRepository.deleteById(reviewId)
        doNothing().when(reviewRepository).deleteById(reviewIdToDelete);

        // Call the method you want to test
        reviewService.deleteReview(reviewIdToDelete);

        // Verify that reviewRepository.deleteById(reviewId) was called with the expected reviewId
        ArgumentCaptor<Long> reviewIdCaptor = ArgumentCaptor.forClass(Long.class);
        verify(reviewRepository).deleteById(reviewIdCaptor.capture());

        // Assert that the captured reviewId matches the expected reviewId
        assertEquals(reviewIdToDelete, reviewIdCaptor.getValue());
    }

    @ParameterizedTest
    @ValueSource(longs = { 1L, 2L, 3L }) // List of vendor IDs to test
    @Transactional
    public void testGetReviewByVendorId(long vendorId) {
        // Prepare mock data for reviewRepository.findByVendorId
        List<Review> expectedReviews = createExpectedReviewsForVendor(vendorId);
        Mockito.when(reviewRepository.findByVendorId(vendorId)).thenReturn(expectedReviews);

        // Call the method you want to test
        List<Review> actualReviews = reviewService.getReviewByVendorId(vendorId);

        // Assert that the returned list of reviews matches the expected result
        assertEquals(expectedReviews, actualReviews);
    }
    private List<Review> createExpectedReviewsForVendor(long vendorId) {
        // For simplicity, we are returning an empty list here.
        return List.of();
    }
}
