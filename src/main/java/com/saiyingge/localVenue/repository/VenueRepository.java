package com.saiyingge.localVenue.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.saiyingge.localVenue.entity.Venue;
import java.util.List;


@Repository
public interface VenueRepository extends CrudRepository<Venue, Long> {
//    find by zipcodes
    List<Venue> findByZipcode(String zipcode);

}