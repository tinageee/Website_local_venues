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
public class VendorDTO {
    private Long id;
    private String name;
    private String description;
    private String contactInformation;
    private String website;
    private List<VenueDTO> VenueDTOList;
    private String imageUrl;


}