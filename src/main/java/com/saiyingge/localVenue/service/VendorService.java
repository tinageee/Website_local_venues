package com.saiyingge.localVenue.service;

import com.saiyingge.localVenue.entity.Vendor;
import com.saiyingge.localVenue.dto.VendorDTO;

import java.util.List;

public interface VendorService {

    Vendor saveVendor(Vendor vendor);

    List<Vendor> getAllVendors();


    VendorDTO getVendorById(long id);
}
