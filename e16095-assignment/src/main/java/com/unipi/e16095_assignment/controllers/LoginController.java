package com.unipi.e16095_assignment.controllers;

import com.unipi.e16095_assignment.dtos.LoginRequestDto;
import com.unipi.e16095_assignment.dtos.UserDto;
import com.unipi.e16095_assignment.services.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping({"/login", "/login/"})
    public ModelAndView getLoginPage() {
        return new ModelAndView("login");
    }

    @PostMapping({"/login", "/login/"})
    public ModelAndView performLoginAction(@ModelAttribute LoginRequestDto loginRequestDto, HttpSession httpSession) {
        UserDto userDto = loginService.performLoginAction(loginRequestDto);

        return loginService.constructModelForResponse(userDto, httpSession);
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Destroys the server-side session
        }
        return "redirect:/api/login?logout=true";
    }

    @GetMapping("/accessDenied")
    public ModelAndView accessDenied() {
        ModelAndView modelAndView = new ModelAndView("errorPage");
        modelAndView.addObject("errorMessage", "Access denied");

        return modelAndView;
    }

    @GetMapping({"/mainPage", "/mainPage/"})
    public ModelAndView mainPage() {
        return new ModelAndView("mainPage");
    }

}
