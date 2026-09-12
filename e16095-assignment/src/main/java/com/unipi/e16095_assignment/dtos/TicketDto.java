package com.unipi.e16095_assignment.dtos;

import com.unipi.e16095_assignment.enums.TicketTypeEnum;

import java.io.Serializable;
import java.util.Objects;

public class TicketDto implements Serializable {

    private Long id;
    private String title;
    private String ticketType;

    public TicketDto() {
    }

    public TicketDto(Long id, String title, String ticketType) {
        this.id = id;
        this.title = title;
        this.ticketType = ticketType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    @Override
    public String toString() {
        return "TicketDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", ticketType='" + ticketType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TicketDto ticketDto = (TicketDto) o;
        return Objects.equals(id, ticketDto.id) && Objects.equals(title, ticketDto.title) && Objects.equals(ticketType, ticketDto.ticketType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, ticketType);
    }
}
