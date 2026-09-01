package com.unipi.e16095_assignment.entities;

import com.unipi.e16095_assignment.enums.StatusEnum;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tickets")
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "T_ID")
    private Integer id;

    @Column(name = "A_TITLE")
    private String title;

    @Column(name = "A_DESCRIPTION")
    private String description;

    @Column(name = "A_STATUS")
    private StatusEnum status;

    @Column(name = "A_")
    private Integer createdBy;

    @Column(name = "A_ASSIGNED_TO")
    private Integer assignedTo;

    @Column(name = "A_CATEGORY_ID")
    private Integer categoryId;

    @Column(name = "A_ATTACHMENT_URL")
    private String attachmentUrl;

    @Column(name = "A_CREATED_AT")
    private Date createdAt;

    @Column(name = "A_UPDATED_AT")
    private Date updatedAt;

    public Tickets() {
//        Empty Constructor
    }

    public Tickets(Integer id, String title, String description, StatusEnum status, Integer createdBy, Integer assignedTo, Integer categoryId, String attachmentUrl, Date createdAt, Date updatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
        this.categoryId = categoryId;
        this.attachmentUrl = attachmentUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Integer assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", createdBy=" + createdBy +
                ", assignedTo=" + assignedTo +
                ", categoryId=" + categoryId +
                ", attachmentUrl='" + attachmentUrl + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tickets tickets = (Tickets) o;
        return Objects.equals(id, tickets.id) && Objects.equals(title, tickets.title) && Objects.equals(description, tickets.description) && status == tickets.status && Objects.equals(createdBy, tickets.createdBy) && Objects.equals(assignedTo, tickets.assignedTo) && Objects.equals(categoryId, tickets.categoryId) && Objects.equals(attachmentUrl, tickets.attachmentUrl) && Objects.equals(createdAt, tickets.createdAt) && Objects.equals(updatedAt, tickets.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, status, createdBy, assignedTo, categoryId, attachmentUrl, createdAt, updatedAt);
    }
}
