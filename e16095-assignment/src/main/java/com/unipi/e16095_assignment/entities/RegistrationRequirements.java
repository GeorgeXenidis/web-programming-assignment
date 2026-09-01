package com.unipi.e16095_assignment.entities;

import com.unipi.e16095_assignment.enums.StatusEnum;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "registration_requirements")
public class RegistrationRequirements {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RR_ID")
    private Integer id;

    @Column(name = "RR_USERNAME")
    private String username;

    @Column(name = "RR_STATUS")
    private StatusEnum status;

    public RegistrationRequirements() {
//        Empty Constructor
    }

    public RegistrationRequirements(Integer id, String username, StatusEnum status) {
        this.id = id;
        this.username = username;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RegistrationRequirements{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationRequirements that = (RegistrationRequirements) o;
        return Objects.equals(id, that.id) && Objects.equals(username, that.username) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, status);
    }
}
