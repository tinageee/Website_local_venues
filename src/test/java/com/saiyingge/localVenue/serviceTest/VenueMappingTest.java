package com.saiyingge.localVenue.serviceTest;

import com.saiyingge.localVenue.dto.VenueDTO;
import com.saiyingge.localVenue.entity.Venue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.modelmapper.ModelMapper;

import java.util.Arrays;


public class VenueMappingTest {

    private final ModelMapper modelMapper = new ModelMapper();

    @Test
    public void testVenueToVenueDtoMapping() {
        // Create and set up a Venue object
        Venue venue = new Venue();
        venue.setId(10L);
        venue.setName("Test Venue");
        venue.setLocation("Test Location");

        // Perform the mapping
        VenueDTO venueDTO = modelMapper.map(venue, VenueDTO.class);

        // Assert the results
        assertNotNull(venueDTO, "VenueDTO should not be null");
        assertEquals(venue.getName(), venueDTO.getName(), "Name should match");
        assertEquals(venue.getLocation(), venueDTO.getLocation(), "Location should match");

    }

    @Test
    public void testVenueWithNullValuesInCollectionsMapping() {
        Venue venue = new Venue();
// Collection with a null value

        VenueDTO venueDTO = modelMapper.map(venue, VenueDTO.class);

        // Assert how these null values are handled in your DTO
    }



}
