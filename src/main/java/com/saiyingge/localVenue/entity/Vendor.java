package com.saiyingge.localVenue.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

/**
 * @author Saiying Ge
 * This entity is used to store the vndoer within the application. each vendor
 * has a unique identifier and a name, can have mutiple venues.
 *
 * @author S.G
*/

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "vendor")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private String contactInformation;
    private String website;


    @ManyToMany(mappedBy = "vendorsList")
    private List<Venue> venuesList;

}
