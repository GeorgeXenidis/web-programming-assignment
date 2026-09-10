package com.unipi.e16095_assignment.controllers;

import com.unipi.e16095_assignment.dtos.LoginRequestDto;
import com.unipi.e16095_assignment.dtos.LoginResponseDto;
import com.unipi.e16095_assignment.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping({"", "/"})
    public ModelAndView getLoginPage() {
        return new ModelAndView("login");
    }

    @PostMapping({"", "/"})
    public ModelAndView performLoginAction(@ModelAttribute LoginRequestDto loginRequestDto) {
        LoginResponseDto loginResponseDto = loginService.performLoginAction(loginRequestDto);

        return loginService.constructModelForResponse(loginResponseDto);
    }

}
