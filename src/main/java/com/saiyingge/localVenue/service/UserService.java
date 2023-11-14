package com.saiyingge.localVenue.service;

import com.saiyingge.localVenue.dto.UserDTO;
import com.saiyingge.localVenue.entity.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

    public UserDetails loadUserByUsername(String userName);

    public void saveUser(UserDTO userDTO);

    public User findUserByEmailForSecurity(String email);

    public UserDTO findUserByEmail(String email);
}
