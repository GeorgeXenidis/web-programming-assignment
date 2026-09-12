package com.unipi.e16095_assignment.mappers;

import com.unipi.e16095_assignment.dtos.TicketDto;
import com.unipi.e16095_assignment.entities.Tickets;

public class TicketMapper {

    public static TicketDto entityToDtoTicketMapper(Tickets ticketEntity) {
        TicketDto ticketDto = new TicketDto();

        ticketDto.setId(ticketEntity.getId());
        ticketDto.setTitle(ticketEntity.getTitle());
        ticketDto.setTicketType(ticketEntity.getTicketType().toString());

        return ticketDto;
    }

}
