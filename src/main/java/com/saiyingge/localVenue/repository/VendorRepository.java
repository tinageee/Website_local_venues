package com.saiyingge.localVenue.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.saiyingge.localVenue.entity.Vendor;
import java.util.List;

@Repository
public interface VendorRepository extends CrudRepository<Vendor, Long> {

}

