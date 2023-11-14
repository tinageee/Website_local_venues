package com.saiyingge.localVenue.service;

import com.saiyingge.localVenue.dto.VenueDTO;
import com.saiyingge.localVenue.entity.Venue;
import com.saiyingge.localVenue.repository.VenueRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VenueServiceImpl implements VenueService {

    private final VenueRepository venueRepository;
    private  ModelMapper modelMapper ;


    @Autowired
    public VenueServiceImpl(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveVenue(Venue venue) {
        venueRepository.save(venue);
    }

    @Override
    public List<Venue> getAllVenues() {
        return  (List<Venue>) venueRepository.findAll();
    }

    @Override
    public List<VenueDTO> findByZipcode(String zipcode) {
        List<Venue> venues = venueRepository.findByZipcode(zipcode);
        return venues.stream()
                .map(venue -> modelMapper.map(venue, VenueDTO.class))
                .collect(Collectors.toList());
    }

//
//    @Override
//    public VenueDTO getVenueById(Long id) {
//        Venue venue = venueRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Venue not found for id: " + id));
//        return modelMapper.map(venue, VenueDTO.class);
//    }


}