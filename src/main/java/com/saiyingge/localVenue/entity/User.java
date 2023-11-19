package com.saiyingge.localVenue.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

/**
 * Entity class representing a User in the application.
 *
 * It includes personal details like name, email, and phone number, along with authentication
 * credentials (email and password). The User entity is linked to the Role entity through a
 * many-to-many relationship, defining the roles assigned to each user.
 * review is a one-to-many relationship, defining the reviews written by each user.
 *
 * @author S.G
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;

    private String username;

    private String email;

    private String password;

    private String phoneNumber;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private Collection<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Review> reviewsList;

    public Long getId() {
        return id;
    }
}
