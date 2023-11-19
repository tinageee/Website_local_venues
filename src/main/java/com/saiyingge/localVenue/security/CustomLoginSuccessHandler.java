package com.saiyingge.localVenue.security;

import com.saiyingge.localVenue.dto.UserDTO;
import com.saiyingge.localVenue.entity.User;

import com.saiyingge.localVenue.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import java.io.IOException;


/**
 * custom success handler ensures that after a successful login,
 * the user is redirected to their account page based on their email,
 * which is retrieved from the authentication object.
 *
 * @author S.G
 */

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
    private static final Logger logger = LoggerFactory.getLogger(CustomLoginSuccessHandler.class);
    @Autowired
    private UserServiceImpl userService;

//    find the user by email and redirect to the user account page
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        logger.info("Login successful");
        String email = authentication.getName();
        User user= userService.findUserByEmailForSecurity(email);
        response.sendRedirect("/account/" + user.getId());
    }
}
