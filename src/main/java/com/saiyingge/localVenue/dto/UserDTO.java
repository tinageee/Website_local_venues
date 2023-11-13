package com.saiyingge.localVenue.dto;

import com.saiyingge.localVenue.entity.Review;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

/**
 * @author Igor Adulyan
 */
@Setter
@Getter
@NoArgsConstructor
public class UserDTO {

    @NotEmpty(message = "Can't be empty string")
    @Size(max = 100)
    private String firstName;

    @NotEmpty(message = "Can't be empty string")
    @Size(max = 100)
    private String lastName;

    @Email(message = "Provide correct email")
    private String email;

    @NotEmpty(message = "Please provide correct password")
    @Size(min = 8, max = 40)
    private String password;

    private String matchingPassword;

    @NotEmpty(message = "Provide phone number")
    private String phoneNumber;

    private List<RoleDTO> RoleDTOList;

    private List<ReviewDTO> ReviewDTOList;
}
