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
    private Long id;
    private String content;
    private Integer rating;

    private Long userId;
    private Long venueId;
    private Long vendorId;
    private String date;
}
