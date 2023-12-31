package com.saiyingge.localVenue.repository;

import com.saiyingge.localVenue.dto.ReviewDTO;
import com.saiyingge.localVenue.entity.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.saiyingge.localVenue.entity.Review;
import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findByUserId(long userId);
    List<Review> findByVenueId(long venueId);
    List<Review> findByVendorId(long vendorId);

}
