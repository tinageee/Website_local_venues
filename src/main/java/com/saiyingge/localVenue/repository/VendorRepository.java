package com.saiyingge.localVenue.repository;

import com.saiyingge.localVenue.dto.VendorDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.saiyingge.localVenue.entity.Vendor;
import java.util.List;
import java.util.Optional;

@Repository
public interface VendorRepository extends CrudRepository<Vendor, Long> {

//    VendorDTO findById(long id);
}

