package com.unipi.e16095_assignment.entities;

import com.unipi.e16095_assignment.enums.TicketStatusEnum;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "t_assignee", referencedColumnName = "u_id", nullable = false)
    private Users assignee;

    @Column(name = "t_ticket_status",
            nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketStatusEnum ticketStatus;

    @Column(name = "t_comments",
            nullable = true)
    private String comments;

    public Tickets() {
    }

    public Tickets(Long id, String title, TicketTypeEnum ticketType, Users assignee, TicketStatusEnum ticketStatus, String comments) {
        this.id = id;
        this.title = title;
        this.ticketType = ticketType;
        this.assignee = assignee;
        this.ticketStatus = ticketStatus;
        this.comments = comments;
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

    public Users getAssignee() {
        return assignee;
    }

    public void setAssignee(Users assignee) {
        this.assignee = assignee;
    }

    public TicketStatusEnum getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatusEnum ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", ticketType=" + ticketType +
                ", assignee=" + assignee +
                ", ticketStatus=" + ticketStatus +
                ", comments='" + comments + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tickets tickets = (Tickets) o;
        return Objects.equals(id, tickets.id) && Objects.equals(title, tickets.title) && ticketType == tickets.ticketType && Objects.equals(assignee, tickets.assignee) && ticketStatus == tickets.ticketStatus && Objects.equals(comments, tickets.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, ticketType, assignee, ticketStatus, comments);
    }
}
