package com.unipi.e16095_assignment.controllers;

import com.unipi.e16095_assignment.dtos.AnnouncementDto;
import com.unipi.e16095_assignment.services.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/api/level-user")
public class AnnouncementsController {

    @Autowired
    private AnnouncementService announcementService;

    @GetMapping({"/announcements/all", "/announcements/all/"})
    public ModelAndView getAllAnnouncements() {
        ModelAndView modelAndView = new ModelAndView("allAnnouncementsPage");

        List<AnnouncementDto> allAnnouncementsList = announcementService.getAllAnnouncements();
        modelAndView.addObject("allAnnouncementsList", allAnnouncementsList);

        return modelAndView;
    }

    @PostMapping({"/announcements/delete/{id}", "/announcements/delete/{id}/"})
    public ModelAndView deleteAnnouncement(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("allAnnouncementsPage");

        announcementService.deleteAnnouncement(id);

        return modelAndView;
    }

}
