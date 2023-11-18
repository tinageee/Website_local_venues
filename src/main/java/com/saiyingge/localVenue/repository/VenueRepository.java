package com.saiyingge.localVenue.repository;

import com.saiyingge.localVenue.dto.VenueDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.saiyingge.localVenue.entity.Venue;
import java.util.List;


@Repository
public interface VenueRepository extends CrudRepository<Venue, Long> {
//    find by zipcodes
    List<Venue> findByZipCode(int zipCode);
//    Venue findById(long id);

}
