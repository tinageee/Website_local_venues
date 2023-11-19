package com.saiyingge.localVenue.dto;

import com.saiyingge.localVenue.entity.Review;
import com.saiyingge.localVenue.entity.Vendor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ReviewDTO {
    private long id;
    private String content;
    private Integer rating;

    private long userId;
    private long venueId;
    private long vendorId;
    private String Date;
    private LocalDateTime createdDate;
    private LocalDateTime lastEditDate;

    public void setUserId(long userId) {
        this.userId = userId;
    }
    public void setVenueId(long venueId) {
        this.venueId = venueId;
    }
    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
    }


    public void setContent(String content) {
        this.content = content;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }


    public void setLastEditDate() {
        LocalDateTime lastEditDate = LocalDateTime.now();
        this.lastEditDate = lastEditDate;
    }
}
