package com.saiyingge.localVenue.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.saiyingge.localVenue.entity.Review;
import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findByUserId(Long userId);
    List<Review> findByVenueId(Long venueId);
    List<Review> findByVendorId(Long vendorId);

}
