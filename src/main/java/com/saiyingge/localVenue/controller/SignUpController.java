package com.saiyingge.localVenue.controller;


import com.saiyingge.localVenue.dto.UserDTO;
import com.saiyingge.localVenue.service.UserService;
import com.saiyingge.localVenue.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * handling user sign-up related functionality.
 * It provides endpoints for displaying a sign-up form ("/form"), processing user sign-up ("/sign-up-process"),
 * and displaying a confirmation page ("/confirmation-page")
 *
 * @author S.G
 */
@Controller
public class SignUpController {

    private UserServiceImpl userServiceImpl;

    @Autowired
    public SignUpController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/form")
    public String signUpForm(Model model) {

        model.addAttribute("userDto", new UserDTO());

        return "sign-up";
    }


    @PostMapping("/sign-up-process")
    public String signUpProcess(@Valid @ModelAttribute("userDto") UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "sign-up";
        }

        userServiceImpl.saveUser(userDTO);

        return "redirect:/confirmation-page";
    }


    @GetMapping("/confirmation-page")
    public String confirmationPage() {
        return "confirmation";
    }


}
