package com.saiyingge.localVenue.dto;

import com.saiyingge.localVenue.entity.Vendor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class VenueDTO {
    private Long id;
    private String name;
    private String location;
    private String description;
    private String facilityDetails;
    private String openingHours;
    private String type;
    private String fee;

    private List<VendorDTO> VendorDTOList;

}

