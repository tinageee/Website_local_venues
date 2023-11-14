package com.saiyingge.localVenue.service;

import com.saiyingge.localVenue.dto.VendorDTO;
import com.saiyingge.localVenue.entity.Vendor;
import com.saiyingge.localVenue.repository.VendorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public void saveVendor(Vendor vendor) {
        vendorRepository.save(vendor);
    }

    @Override
    public List<Vendor> getAllVendors() {
        return (List<Vendor>) vendorRepository.findAll();
    }




}
