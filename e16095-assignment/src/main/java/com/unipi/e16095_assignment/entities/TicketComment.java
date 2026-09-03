package com.unipi.e16095_assignment.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ticket_comments")
public class TicketComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TCO_ID")
    private Integer id;

    @Column(name = "TCO_TICKET_ID")
    private Integer ticketId;

    @Column(name = "TCO_USER_ID")
    private Integer userId;

    @Column(name = "TCO_COMMENT")
    private String comment;

    @Column(name = "TCO_CREATED_AT")
    private Date createdAt;

    public TicketComment() {
//        Empty Constructor
    }

    public TicketComment(Integer id, Integer ticketId, Integer userId, String comment, Date createdAt) {
        this.id = id;
        this.ticketId = ticketId;
        this.userId = userId;
        this.comment = comment;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "TicketComment{" +
                "id=" + id +
                ", ticketId=" + ticketId +
                ", userId=" + userId +
                ", comment='" + comment + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TicketComment that = (TicketComment) o;
        return Objects.equals(id, that.id) && Objects.equals(ticketId, that.ticketId) && Objects.equals(userId, that.userId) && Objects.equals(comment, that.comment) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ticketId, userId, comment, createdAt);
    }
}
