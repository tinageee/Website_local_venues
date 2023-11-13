package com.saiyingge.localVenue.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.*;

/**
 * Entity class representing a User in the application.
 * Each user has a unique identifier, a username, a password, a first name, a last name,
 * a phone number, an email address, a role, and a set of reviews.
 *
 * @author S.G
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;


}
