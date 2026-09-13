package com.unipi.e16095_assignment.controllers;

import com.unipi.e16095_assignment.dtos.TicketDto;
import com.unipi.e16095_assignment.dtos.UserDto;
import com.unipi.e16095_assignment.services.TicketService;
import com.unipi.e16095_assignment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    @GetMapping({"/getAllUsers", "/getAllUsers/"})
    public ModelAndView getAllUsers() {
        ModelAndView modelAndView = new ModelAndView("allUsersPage");

        List<UserDto> allUsersList = userService.getAllUsers();
        modelAndView.addObject("allUsersList", allUsersList);

        return modelAndView;
    }

    @GetMapping("/userDetails/{id}")
    public ModelAndView getUserDetails(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("userDetailsPage");

        UserDto userDto = userService.findUserById(id);
        modelAndView.addObject("userDto", userDto);

        return modelAndView;
    }

    @PostMapping({"/userDetails/updateUser", "/userDetails/updateUser/"})
    public ModelAndView updateUser(@RequestBody UserDto userDto) {
        ModelAndView modelAndView = new ModelAndView("userDetailsPage");

        UserDto updatedUserDto = userService.updateUser(userDto);
        modelAndView.addObject("userDto", updatedUserDto);

        return modelAndView;
    }

    @PostMapping("/userDetails/delete")
    public ModelAndView deleteUser(@RequestParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("allUsersPage");

        userService.deleteUserById(id);

        List<UserDto> allUsersList = userService.getAllUsers();
        modelAndView.addObject("allUsersList", allUsersList);

        return modelAndView;
    }

    @GetMapping({"/tickets/all", "/tickets/all/"})
    public ModelAndView getAllTickets() {
        ModelAndView modelAndView = new ModelAndView("allTicketsPage");

        List<TicketDto> allTicketsList = ticketService.getAllTickets();
        modelAndView.addObject("allTicketsList", allTicketsList);

        return modelAndView;
    }

    @GetMapping({"/ticketDetails/{id}", "/ticketDetails/{id}/"})
    public ModelAndView getTicketDetails(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("ticketDetailsPage");

        TicketDto ticketDto = ticketService.findTicketById(id);
        modelAndView.addObject("ticketDto", ticketDto);

        return modelAndView;
    }

    @PostMapping({"/ticketDetails/updateTicket", "/ticketDetails/updateTicket"})
    public ModelAndView updateTicket(@RequestBody TicketDto ticketDto) {
        ModelAndView modelAndView = new ModelAndView("ticketDetailsPage");

        TicketDto updatedTicketDto = ticketService.updateTicket(ticketDto);
        modelAndView.addObject("ticketDto", updatedTicketDto);

        return modelAndView;
    }

}
