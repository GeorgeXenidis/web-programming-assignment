package com.unipi.e16095_assignment.entities;

import com.unipi.e16095_assignment.enums.TicketTypeEnum;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tickets")
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id")
    private Long id;

    @Column(name = "t_title",
            nullable = false)
    private String title;

    @Column(name = "t_type")
    @Enumerated(EnumType.STRING)
    private TicketTypeEnum ticketType;

    public Tickets() {
    }

    public Tickets(Long id, String title, TicketTypeEnum ticketType) {
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

    public TicketTypeEnum getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketTypeEnum ticketType) {
        this.ticketType = ticketType;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", ticketType=" + ticketType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tickets tickets = (Tickets) o;
        return Objects.equals(id, tickets.id) && Objects.equals(title, tickets.title) && ticketType == tickets.ticketType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, ticketType);
    }
}
