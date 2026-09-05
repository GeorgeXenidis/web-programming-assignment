package com.unipi.e16095_assignment.entities;

import com.unipi.e16095_assignment.enums.RoleEnum;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "u_id")
    private Long id;

    @Column(
            name = "u_username",
            nullable = false)
    private String username;

    @Column(name = "u_password",
            nullable = false)
    private String password;

    @Column(name = "u_email",
            nullable = true)
    private String email;

    @Column(name = "u_role",
            nullable = false)
    private RoleEnum roleEnum;

    public Users() {
    }

    public Users(Long id, String username, String password, String email, RoleEnum roleEnum) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roleEnum = roleEnum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoleEnum getRole() {
        return roleEnum;
    }

    public void setRole(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roleEnum=" + roleEnum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(id, users.id) && Objects.equals(username, users.username) && Objects.equals(password, users.password) && Objects.equals(email, users.email) && roleEnum == users.roleEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, roleEnum);
    }
}
