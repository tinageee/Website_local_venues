package com.saiyingge.localVenue.service;

import com.saiyingge.localVenue.entity.Vendor;
import com.saiyingge.localVenue.dto.VendorDTO;

import java.util.List;

public interface VendorService {

    void saveVendor(Vendor vendor);

    List<Vendor> getAllVendors();
//
//    List<VendorDTO> findByZipcode(String zipcode);

}
