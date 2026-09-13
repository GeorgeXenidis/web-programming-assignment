package com.unipi.e16095_assignment.controllers;

import com.unipi.e16095_assignment.dtos.TicketDto;
import com.unipi.e16095_assignment.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/api/level-tech")
public class TicketController {

    @Autowired
    private TicketService ticketService;

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
