package com.saiyingge.localVenue.serviceTest;


import com.saiyingge.localVenue.dto.VendorDTO;
import com.saiyingge.localVenue.repository.VendorRepository;
import com.saiyingge.localVenue.service.VendorServiceImpl;
import com.saiyingge.localVenue.entity.Vendor;
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
public class VendorServiceTest {

    private VendorServiceImpl vendorService;

    @Mock
    private VendorRepository vendorRepository;
    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        vendorService = new VendorServiceImpl(vendorRepository,modelMapper);
    }


    @Test
    public void testConstructorInjection() throws Exception {
        // Use reflection to access the private vendorRepository field
        Field vendorRepositoryField = VendorServiceImpl.class.getDeclaredField("vendorRepository");
        ((Field) vendorRepositoryField).setAccessible(true);
        VendorRepository vendorRepository = (VendorRepository) vendorRepositoryField.get(vendorService);

        // Verify that the vendorRepository is not null
        assertNotNull(vendorRepository);
    }
    @Test
    public void testSaveVendor() {
        Vendor vendorToSave = new Vendor();
        vendorToSave.setId(10); // Set any necessary fields for the vendor

        when(vendorRepository.save(vendorToSave)).thenReturn(vendorToSave);

        Vendor savedVendor = vendorService.saveVendor(vendorToSave);

        verify(vendorRepository, times(1)).save(vendorToSave);

        // Assert that the returned vendor matches the one we saved
        assertEquals(vendorToSave, savedVendor);
    }

    @Test
    public void testGetAllVendors() {
        List<Vendor> vendorList = new ArrayList<>();
        // Add one or more Vendor objects to the list

        when(vendorRepository.findAll()).thenReturn(vendorList);

        List<Vendor> result = vendorService.getAllVendors();

        verify(vendorRepository, times(1)).findAll();

        // Assert that the result list matches the one we provided
        assertEquals(vendorList, result);
    }





}
