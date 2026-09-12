package com.unipi.e16095_assignment.services;

import com.unipi.e16095_assignment.dtos.TicketDto;
import com.unipi.e16095_assignment.entities.Tickets;
import com.unipi.e16095_assignment.enums.TicketTypeEnum;
import com.unipi.e16095_assignment.mappers.TicketMapper;
import com.unipi.e16095_assignment.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static com.unipi.e16095_assignment.mappers.TicketMapper.entityToDtoTicketMapper;

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

    public TicketDto findTicketById(Long id) {
        Optional<Tickets> optionalTicket = ticketRepository.findById(id);
        if (optionalTicket.isEmpty()) {
            return new TicketDto(id, "", "");
        }

        return entityToDtoTicketMapper(optionalTicket.get());
    }

    public TicketDto updateTicket(TicketDto newTicketDto) {
        Optional<Tickets> existingTicket = ticketRepository.findById(newTicketDto.getId());
        if (existingTicket.isEmpty()) {
            throw new NoSuchElementException("Ticket not found with ID: " + newTicketDto.getId());
        }

        Tickets ticketToSave = updateTicketInfo(existingTicket.get(), newTicketDto);
        Tickets savedTicket = ticketRepository.save(ticketToSave);

        return entityToDtoTicketMapper(savedTicket);
    }

    private Tickets updateTicketInfo(Tickets existingTicket, TicketDto newTicketDto) {
//        ID has not to be set as it is already present when fetched from DB

//        Perform null/empty checks in order to configure which values are being requested for update
        if (newTicketDto.getTicketType() == null || newTicketDto.getTicketType().isBlank()) {
            return existingTicket;
        }

        existingTicket.setTicketType(TicketTypeEnum.valueOf(newTicketDto.getTicketType()));

        return existingTicket;
    }

}
