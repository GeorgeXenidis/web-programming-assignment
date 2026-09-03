package com.unipi.e16095_assignment.controllers;

import com.unipi.e16095_assignment.dtos.LoginRequestDto;
import com.unipi.e16095_assignment.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        // Strip leading slash and .html extension
        ModelAndView modelAndView = new ModelAndView("login");
//        modelAndView.addObject("someAttribute", "someValue");

        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView performLoginAction(@RequestBody LoginRequestDto loginRequestDto) {
        authService.login(loginRequestDto);
    }

}
