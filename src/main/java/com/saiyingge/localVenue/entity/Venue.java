package com.saiyingge.localVenue.entity;

/**
 * @author Saiying Ge
 * This entity is used to store the venue within the application. Each venue
 * has a unique identifier and a name, can have mutiple vendors, and can have mutiple reviews.
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.*;

import java.util.List;



@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "venue")
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String location;
    private String description;
    private String facilityDetails;
    private String openingHours;
    private String type;
    private String fee;
    private int zipCode;
    private String contactInformation;
    private String website;
    @Column(name = "image_url", length = 1000)
    private String imageUrl;

    @OneToMany(mappedBy = "venue")
    private List<Review> reviews;

    @ManyToMany
    @JoinTable(
            name = "venue_vendor",
            joinColumns = @JoinColumn(name = "venue_id"),
            inverseJoinColumns = @JoinColumn(name = "vendor_id")
    )
    private List<Vendor> vendorsList;

    @Override
    public String toString() {
        return "Venue{" +
                "id=" + id +
                ", name='" + name + '\'' +

                '}';
    }
}
