package com.saiyingge.localVenue.service;

import com.saiyingge.localVenue.dto.VendorDTO;
import com.saiyingge.localVenue.entity.Vendor;
import com.saiyingge.localVenue.repository.VendorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class VendorServicelmpl implements VendorService {

    private final VendorRepository vendorRepository;
    private ModelMapper modelMapper;

    @Autowired
    public VendorServicelmpl(VendorRepository vendorRepository, ModelMapper modelMapper) {
        this.vendorRepository = vendorRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Vendor saveVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }


    @Override
    public List<Vendor> getAllVendors() {
        return (List<Vendor>) vendorRepository.findAll();
    }


    @Override
    public VendorDTO getVendorById(long id) {
        Vendor vendor = vendorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor not found for id: " + id));
        return modelMapper.map(vendor, VendorDTO.class);
    }
}
