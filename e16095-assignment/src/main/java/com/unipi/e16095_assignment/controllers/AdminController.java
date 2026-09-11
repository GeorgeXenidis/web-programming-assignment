package com.unipi.e16095_assignment.controllers;

import com.unipi.e16095_assignment.dtos.UserDto;
import com.unipi.e16095_assignment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping({"/getAllUsers", "/getAllUsers/"})
    public ModelAndView getAllUsers() {
        ModelAndView modelAndView = new ModelAndView();

        List<UserDto> allUsersList = userService.getAllUsers();
        modelAndView.addObject("allUsersList", allUsersList);

        return modelAndView;
    }

}
