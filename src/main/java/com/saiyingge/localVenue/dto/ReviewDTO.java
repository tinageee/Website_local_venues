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
public class ReviewDTO {
    private int id;
    private String content;
    private Integer rating;

    private int userId;
    private int venueId;
    private int vendorId;
    private String date;
}
