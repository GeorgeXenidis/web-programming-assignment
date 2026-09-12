package com.unipi.e16095_assignment.services;

import com.unipi.e16095_assignment.dtos.TicketDto;
import com.unipi.e16095_assignment.mappers.TicketMapper;
import com.unipi.e16095_assignment.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<TicketDto> getAllTickets() {
        return ticketRepository.findAll()
                .stream()
                .map(TicketMapper::entityToDtoTicketMapper)
                .toList();
    }

}
