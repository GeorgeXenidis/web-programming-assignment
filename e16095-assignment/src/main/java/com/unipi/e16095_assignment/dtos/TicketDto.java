package com.unipi.e16095_assignment.dtos;

import com.unipi.e16095_assignment.enums.TicketTypeEnum;

import java.io.Serializable;
import java.util.Objects;

public class TicketDto implements Serializable {

    private Long id;
    private String title;
    private String ticketType;
    private Long assigneeId;
    private String ticketStatus;
    private String comments;
    private Long submittingEntityId;

    public TicketDto() {
    }

    public TicketDto(Long id, String title, String ticketType, Long assigneeId, String ticketStatus, String comments, Long submittingEntityId) {
        this.id = id;
        this.title = title;
        this.ticketType = ticketType;
        this.assigneeId = assigneeId;
        this.ticketStatus = ticketStatus;
        this.comments = comments;
        this.submittingEntityId = submittingEntityId;
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

    public Long getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(Long assigneeId) {
        this.assigneeId = assigneeId;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Long getSubmittingEntityId() {
        return submittingEntityId;
    }

    public void setSubmittingEntityId(Long submittingEntityId) {
        this.submittingEntityId = submittingEntityId;
    }

    @Override
    public String toString() {
        return "TicketDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", ticketType='" + ticketType + '\'' +
                ", assigneeId=" + assigneeId +
                ", ticketStatus='" + ticketStatus + '\'' +
                ", comments='" + comments + '\'' +
                ", submittingEntityId=" + submittingEntityId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TicketDto ticketDto = (TicketDto) o;
        return Objects.equals(id, ticketDto.id) && Objects.equals(title, ticketDto.title) && Objects.equals(ticketType, ticketDto.ticketType) && Objects.equals(assigneeId, ticketDto.assigneeId) && Objects.equals(ticketStatus, ticketDto.ticketStatus) && Objects.equals(comments, ticketDto.comments) && Objects.equals(submittingEntityId, ticketDto.submittingEntityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, ticketType, assigneeId, ticketStatus, comments, submittingEntityId);
    }
}
