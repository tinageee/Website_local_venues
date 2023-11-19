package com.saiyingge.localVenue.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.*;
import java.time.LocalDateTime;
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
    private long id;

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

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "last_edit_date")
    private LocalDateTime lastEditDate;
    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
        lastEditDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        lastEditDate = LocalDateTime.now();
    }
    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                // other fields
                // Include only the Venue's ID, not the whole object
                ", venueId=" + (venue != null ? venue.getId() : null) +
                '}';
    }

}
