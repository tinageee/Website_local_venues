package com.saiyingge.localVenue.dto;

import com.saiyingge.localVenue.entity.Review;
import com.saiyingge.localVenue.entity.User;
import com.saiyingge.localVenue.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class UserDTO {

    private long id;

    @NotEmpty(message = "Can't be empty string")
    @Size(max = 100)
    private String firstName;

    @NotEmpty(message = "Can't be empty string")
    @Size(max = 100)
    private String lastName;

    private String username;
    @Email(message = "Provide correct email")
    private String email;


    @NotEmpty(message = "Please provide correct password")
    @Size(min = 8, max = 40)
    private String password;

    private String matchingPassword;

    @NotEmpty(message = "Provide phone number")
    private String phoneNumber;

    private List<Role> RoleList;

    private List<ReviewDTO> ReviewDTOList;


    public void setId(long id) {
        this.id = id;
    }
}
