package com.unipi.e16095_assignment.controllers;

import com.unipi.e16095_assignment.dtos.LoginRequestDto;
import com.unipi.e16095_assignment.dtos.LoginResponseDto;
import com.unipi.e16095_assignment.enums.RoleEnum;
import com.unipi.e16095_assignment.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView performLoginAction(@RequestParam LoginRequestDto loginRequestDto) {
        LoginResponseDto loginResponseDto = loginService.performLoginAction(loginRequestDto);

        switch (loginResponseDto.getRoleEnum().toString()) {
            case "ADMIN":
                return new ModelAndView("adminMainPage");
            case "TECHNICIAN":
                return new ModelAndView("technicianMainPage");
            case "SIMPLE_USER":
                return new ModelAndView("simpleUserMainPage");
            default:
                return new ModelAndView("roleNotFoundErrorPage");
        }
    }

}
