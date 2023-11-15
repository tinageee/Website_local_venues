package com.saiyingge.localVenue.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Saiying Ge
 * This entity is used to store the roles of users within the application. Each role
 * has a unique identifier and a name.
 *
 * @author S.G
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    public Role(String name) {
        this.name = name;
    }

//    @OneToMany(mappedBy = "role")
//    private List<User> users;
}
