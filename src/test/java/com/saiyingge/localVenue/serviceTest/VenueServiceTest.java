package com.saiyingge.localVenue.serviceTest;

import com.saiyingge.localVenue.dto.VenueDTO;
import com.saiyingge.localVenue.repository.VenueRepository;
import com.saiyingge.localVenue.entity.Venue;
import com.saiyingge.localVenue.service.VenueServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VenueServiceTest {

    private VenueServiceImpl venueService;

    @Mock
    private VenueRepository venueRepository;
    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        modelMapper = mock(ModelMapper.class);

        venueService = new VenueServiceImpl(venueRepository, modelMapper);
    }

    @Test
    public void testConstructorInjection() throws Exception {
        // Use reflection to access the private venueRepository field
        Field venueRepositoryField = VenueServiceImpl.class.getDeclaredField("venueRepository");
        ((Field) venueRepositoryField).setAccessible(true);
        VenueRepository venueRepository = (VenueRepository) venueRepositoryField.get(venueService);

        // Verify that the venueRepository is not null
        assertNotNull(venueRepository);
    }
    @Test
    public void testSaveVenue() {
        Venue venueToSave = new Venue();
        venueToSave.setId(10); // Set any necessary fields for the venue

        venueService.saveVenue(venueToSave);

        verify(venueRepository, times(1)).save(venueToSave);
    }

    @Test
    public void testGetAllVenues() {
        List<Venue> venueList = new ArrayList<>();
        // Add one or more Venue objects to the list

        when(venueRepository.findAll()).thenReturn(venueList);

        List<Venue> result = venueService.getAllVenues();

        verify(venueRepository, times(1)).findAll();

        // Assert that the result list matches the one we provided
        assertEquals(venueList, result);
    }

    @Test
    public void testGetVenuesByZipCode() {
        List<Venue> venueList = new ArrayList<>();
        // Add one or more Venue objects to the list

        when(venueRepository.findByZipCode(12345)).thenReturn(venueList);

        List<VenueDTO> result = venueService.getbyZipcode(12345);

        verify(venueRepository, times(1)).findByZipCode(12345);

        // Assert that the result list matches the one we provided
        assertEquals(venueList, result);
    }

    @Test
    public void testGetVenueById() {
        // Create an expected Venue object
        Venue expectedVenue = new Venue();
        expectedVenue.setId(10);
        expectedVenue.setName("Example Venue");
        expectedVenue.setLocation("Example Location");

        // Mock the behavior of the venueRepository.findById method to return the expectedVenue
        when(venueRepository.findById(10L)).thenReturn(Optional.of(expectedVenue));

        // Call the service method
        VenueDTO result = venueService.getVenueById(10L);

        // Verify that venueRepository.findById was called with the correct argument
        verify(venueRepository, times(1)).findById(10L);

        // Assert that the result matches the expectedVenue
        assertEquals(expectedVenue.getName(), result.getName());
        assertEquals(expectedVenue.getLocation(), result.getLocation());
        // Repeat for other fields as needed
    }

}
