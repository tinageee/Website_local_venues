package com.saiyingge.localVenue.controller;


import com.saiyingge.localVenue.dto.UserDTO;
import com.saiyingge.localVenue.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class SignUpController {

    private UserService userService;

    @Autowired
    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/form")
    public String signUpForm(Model model){

        model.addAttribute("userDto", new UserDTO());

        return "sign-up";
    }


    @PostMapping("/sign-up-process")
    public String signUpProcess(@Valid @ModelAttribute("userDto") UserDTO userDTO, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "sign-up";
        }

        userService.saveUser(userDTO);

        return "redirect:/confirmation-page";
    }


    @GetMapping("/confirmation-page")
    public String confirmationPage()
    {
        return "confirmation";
    }


}
