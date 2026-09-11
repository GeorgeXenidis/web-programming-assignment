package com.unipi.e16095_assignment.controllers;

import com.unipi.e16095_assignment.dtos.UserDto;
import com.unipi.e16095_assignment.services.RegistrationService;
import com.unipi.e16095_assignment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/api/register")
public class RegisterController {

    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private UserService userService;

    @GetMapping({"", "/"})
    public ModelAndView getRegisterPage() {
        return new ModelAndView("registerUserPage");
    }

    @PostMapping({"", "/"})
    public ResponseEntity<String> register(@ModelAttribute UserDto userDto) {
        registrationService.registerUser(userDto);

        return new ResponseEntity<>(
                "Thank you for your registration!",
                HttpStatus.OK
        );
    }

    @GetMapping({"/approvals", "/approvals/"})
    public ModelAndView getAllPendingRegistrations() {
        ModelAndView modelAndView = new ModelAndView("pendingRegistrations");

        List<UserDto> allPendingRegistrationsList = registrationService.getAllPendingRegistrations();
        modelAndView.addObject("allPendingRegistrationsList", allPendingRegistrationsList);

        return modelAndView;
    }

    @PostMapping({"/approvals", "/approvals/"})
    @ResponseBody
    public ModelAndView handleRegistrationApproval(@RequestBody UserDto userDto,
                                                   @RequestParam("action") String action) {
        ModelAndView modelAndView = new ModelAndView("pendingRegistrations");

        boolean isRegistrationApproved = registrationService.handleApproval(userDto.getId(), action);
        if (isRegistrationApproved) {
            userService.saveUser(userDto);
        }
        modelAndView.addObject("isRegistrationApproved", isRegistrationApproved);

        return modelAndView;
    }

}
