package com.saiyingge.localVenue.service;


import com.saiyingge.localVenue.entity.Venue;
import com.saiyingge.localVenue.dto.VenueDTO;

import java.util.List;


public interface VenueService {



    void saveVenue(Venue venue);

    List<Venue> getAllVenues();

    List<VenueDTO> findByZipcode(String zipcode);
//
//    VenueDTO getVenueById(Long id);
}
