package com.unipi.e16095_assignment.controllers;

import com.unipi.e16095_assignment.dtos.TicketDto;
import com.unipi.e16095_assignment.dtos.UserDto;
import com.unipi.e16095_assignment.enums.RoleEnum;
import com.unipi.e16095_assignment.services.TicketService;
import com.unipi.e16095_assignment.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private TicketService ticketService;

    @GetMapping({"/level-admin/getAllUsers", "/level-admin/getAllUsers/"})
    public ModelAndView getAllUsers() {
        ModelAndView modelAndView = new ModelAndView("allUsersPage");

        List<UserDto> allUsersList = userService.getAllUsers();
        modelAndView.addObject("allUsersList", allUsersList);

        return modelAndView;
    }

    @GetMapping("/level-admin/userDetails/{id}")
    public ModelAndView getUserDetails(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("userDetailsPage");

        UserDto userDto = userService.findUserById(id);
        modelAndView.addObject("userDto", userDto);

        return modelAndView;
    }

    @PostMapping({"/level-admin/userDetails/updateUser", "/level-admin/userDetails/updateUser/"})
    public ModelAndView updateUser(@RequestBody UserDto userDto) {
        ModelAndView modelAndView = new ModelAndView("userDetailsPage");

        UserDto updatedUserDto = userService.updateUser(userDto);
        modelAndView.addObject("userDto", updatedUserDto);

        return modelAndView;
    }

    @PostMapping("/level-admin/userDetails/delete")
    public ModelAndView deleteUser(@RequestParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("allUsersPage");

        userService.deleteUserById(id);

        List<UserDto> allUsersList = userService.getAllUsers();
        modelAndView.addObject("allUsersList", allUsersList);

        return modelAndView;
    }

    @GetMapping({"/level-user/application/newTicketForm", "/level-user/application/newTicketForm/"})
    public ModelAndView getTicketFormPage() {
        ModelAndView modelAndView = new ModelAndView("newTicketFormPage");

        modelAndView.addObject("ticketDto", new TicketDto(null, "", "", null, null, "", null));

        return modelAndView;
    }

    @PostMapping({"/level-user/application/newTicketForm", "/level-user/application/newTicketForm/"})
    @ResponseBody
    public ResponseEntity<?> newTicketFormApplication(@RequestBody TicketDto ticketDto, HttpSession httpSession) {
        try {
            // Retrieve current logged-in user from session if needed
            UserDto loggedInUser = (UserDto) httpSession.getAttribute("loggedInUser");

            if (isRoleUser(loggedInUser)) {
                ticketDto.setSubmittingEntityId(loggedInUser.getId());
                ticketService.saveNewTicket(ticketDto);

                return ResponseEntity.ok().build();
            }

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to submit ticket: " + e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping({"/level-user/application/getAllOwned", "/level-user/application/getAllOwned/"})
    public ModelAndView getAllOwnedTickets(TicketDto ticketDto, HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("allOwnedTicketsPage");

        UserDto loggedInUser = (UserDto) httpSession.getAttribute("loggedInUser");
        ticketDto.setSubmittingEntityId(loggedInUser.getId());

        List<TicketDto> allOwnedTicketsList = ticketService.getOwnedTickets(ticketDto);

        modelAndView.addObject("allOwnedTicketsList", allOwnedTicketsList);

        return modelAndView;
    }

    private boolean isRoleUser(UserDto loggedInUser) {
        return loggedInUser.getRole().equals(RoleEnum.USER.toString());
    }

}
