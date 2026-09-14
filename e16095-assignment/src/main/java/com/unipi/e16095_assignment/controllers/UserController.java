package com.unipi.e16095_assignment.controllers;

import com.unipi.e16095_assignment.dtos.TicketDto;
import com.unipi.e16095_assignment.dtos.UserDto;
import com.unipi.e16095_assignment.enums.RoleEnum;
import com.unipi.e16095_assignment.services.TicketService;
import com.unipi.e16095_assignment.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping({"/level-user/application/technicalSupport", "/level-user/application/technicalSupport/"})
    public ModelAndView getTicketFormPage() {
        ModelAndView modelAndView = new ModelAndView("newTicketFormPage");

        modelAndView.addObject("ticketDto", new TicketDto(null, "", "", null, null, ""));

        return modelAndView;
    }

    @PostMapping({"/level-user/application/technicalSupport", "/level-user/application/technicalSupport/"})
    @ResponseBody
    public ResponseEntity<?> technicalSupportApplication(@RequestBody TicketDto ticketDto, HttpSession httpSession) {
        try {
            // Retrieve current logged-in user from session if needed
            UserDto loggedInUser = (UserDto) httpSession.getAttribute("loggedInUser");

            if (isRoleUser(loggedInUser)) {
                ticketService.saveNewTicket(ticketDto);
            }

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to submit ticket: " + e.getMessage());
        }

        return ResponseEntity.ok().build();
    }

    private boolean isRoleUser(UserDto loggedInUser) {
        return loggedInUser.getRole().equals(RoleEnum.USER.toString());
    }

    private ModelAndView configureUserRole(TicketDto ticketDto, HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();

        if (httpSession.getAttribute("user") != RoleEnum.USER.toString()) {
            modelAndView.setViewName("errorPage");
            modelAndView.addObject("errorMessage", "This operation is ONLY allowed by user roles!");

            return modelAndView;
        }

        TicketDto savedTicketDto = ticketService.saveNewTicket(ticketDto);

        modelAndView.setViewName("newTicketFormPage");

        return modelAndView;
    }

}
