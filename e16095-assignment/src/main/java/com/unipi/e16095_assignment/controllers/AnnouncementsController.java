package com.unipi.e16095_assignment.controllers;

import com.unipi.e16095_assignment.dtos.AnnouncementDto;
import com.unipi.e16095_assignment.dtos.TicketDto;
import com.unipi.e16095_assignment.dtos.UserDto;
import com.unipi.e16095_assignment.enums.RoleEnum;
import com.unipi.e16095_assignment.services.AnnouncementService;
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
public class AnnouncementsController {

    @Autowired
    private AnnouncementService announcementService;

    @GetMapping({"/level-user/announcements/all", "/level-user/announcements/all/"})
    public ModelAndView getAllAnnouncements() {
        ModelAndView modelAndView = new ModelAndView("allAnnouncementsPage");

        List<AnnouncementDto> allAnnouncementsList = announcementService.getAllAnnouncements();
        modelAndView.addObject("allAnnouncementsList", allAnnouncementsList);

        return modelAndView;
    }

    @GetMapping({"/level-admin/announcements/new", "/level-admin/announcements/new/"})
    public ModelAndView getNewAnnouncementPage() {
        ModelAndView modelAndView = new ModelAndView("newAnnouncementPage");

        modelAndView.addObject("announcementDto", new AnnouncementDto(null, "", ""));

        return modelAndView;
    }

    @PostMapping({"/level-admin/announcements/new", "/level-admin/announcements/new/"})
    @ResponseBody
    public ResponseEntity<?> submitNewAnnouncement(@RequestBody AnnouncementDto announcementDto, HttpSession httpSession) {
        try {
            UserDto loggedInUser = (UserDto) httpSession.getAttribute("loggedInUser");

            if (isRoleAdmin(loggedInUser)) {
                announcementService.newAnnouncement(announcementDto);

                return ResponseEntity.ok().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to submit announcement: " + e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping({"/level-admin/announcements/delete/{id}", "/level-admin/announcements/delete/{id}/"})
    public ModelAndView deleteAnnouncement(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("allAnnouncementsPage");

        announcementService.deleteAnnouncement(id);

        return modelAndView;
    }

    private boolean isRoleAdmin(UserDto loggedInUser) {
        return loggedInUser.getRole().equals(RoleEnum.ADMIN.toString());
    }

}
