package com.unipi.e16095_assignment.controllers;

import com.unipi.e16095_assignment.dtos.RegistrationDto;
import com.unipi.e16095_assignment.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping({"", "/"})
    public ModelAndView getRegisterPage() {
        return new ModelAndView("registerUserPage");
    }

    @PostMapping({"", "/"})
    public ResponseEntity<String> register(@ModelAttribute RegistrationDto registrationDto) {
        registerService.registerUser(registrationDto);

        return new ResponseEntity<>(
                "Thank you for your registration!",
                HttpStatus.OK
        );
    }

}
