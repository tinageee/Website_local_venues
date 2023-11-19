package com.saiyingge.localVenue.service;



import com.saiyingge.localVenue.dto.UserDTO;
import com.saiyingge.localVenue.entity.Role;
import com.saiyingge.localVenue.entity.User;
import com.saiyingge.localVenue.repository.UserRepository;


import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * adopted from examples from spring bot basic 2
 */
@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    private RoleService roleService;

    private BCryptPasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService, @Lazy BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userOptional = userRepository.findUserByEmail(username);
        if(userOptional.isEmpty())
        {
            throw new UsernameNotFoundException("User doesn't exist");
        }
        else {

            User user = userOptional.get();

            List<Role> roleList = roleService.findRolesByUserId(user.getId());

            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                    mapRolesToAuthorities(roleList));
        }
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        Collection<? extends GrantedAuthority>
                mapRoles = roles.stream().map( role -> new SimpleGrantedAuthority(role.getName())).toList();

        return mapRoles;
    }

    @Override
    @Transactional
    public void saveUser(UserDTO userDTO) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        User user = modelMapper.map(userDTO, User.class);
        user.setRoles(Arrays.asList(roleService.findRoleByName("ROLE_EMPLOYEE")));
        user.setPassword(encoder.encode(userDTO.getPassword()));

        userRepository.save(user);
    }

    @Override
    @Transactional
    public User findUserByEmailForSecurity(String email) {
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

    }

    @Override
    @Transactional
    public UserDTO findUserByEmail(String email) {

        Optional<User> userOptional = userRepository.findUserByEmail(email);

        if(userOptional.isPresent()) {

            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

            UserDTO userDTO = modelMapper.map(userOptional.get(), UserDTO.class);

            return userDTO;
        }
        else
            throw new RuntimeException("User does not exist");

    }
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }
}
