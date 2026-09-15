package com.unipi.e16095_assignment.mappers;

import com.unipi.e16095_assignment.dtos.TicketDto;
import com.unipi.e16095_assignment.entities.Tickets;
import com.unipi.e16095_assignment.enums.TicketStatusEnum;
import com.unipi.e16095_assignment.enums.TicketTypeEnum;

public class TicketMapper {

    public static TicketDto entityToDtoTicketMapper(Tickets ticketEntity) {
        TicketDto ticketDto = new TicketDto();

        ticketDto.setId(ticketEntity.getId());
        ticketDto.setTitle(ticketEntity.getTitle());
        ticketDto.setTicketType(ticketEntity.getTicketType().toString());
        ticketDto.setTicketStatus(ticketEntity.getTicketStatus().toString());
        ticketDto.setComments(ticketEntity.getComments());

        // Safely retrieve entity IDs if present
        if (ticketEntity.getAssignee() != null) {
            ticketDto.setAssigneeId(ticketEntity.getAssignee().getId());
        } else {
            ticketDto.setAssigneeId(null);
        }
        if (ticketEntity.getSubmittingEntity() != null) {
            ticketDto.setSubmittingEntityId(ticketEntity.getSubmittingEntity().getId());
        } else {
            ticketDto.setSubmittingEntityId(null);
        }

        return ticketDto;
    }

    public static Tickets dtoToEntityTicketMapper(TicketDto ticketDto) {
        Tickets ticketEntity = new Tickets();

        ticketEntity.setTitle(ticketDto.getTitle());
        ticketEntity.setTicketType(TicketTypeEnum.valueOf(ticketDto.getTicketType()));
        ticketEntity.setAssignee(null);// Assignee is to be chosen by admin or technician
        ticketEntity.setTicketStatus(TicketStatusEnum.NOT_ASSIGNED);
        ticketEntity.setComments(ticketDto.getComments());
        ticketEntity.setSubmittingEntity(null);// TODO: Check this case

        return ticketEntity;
    }

}
