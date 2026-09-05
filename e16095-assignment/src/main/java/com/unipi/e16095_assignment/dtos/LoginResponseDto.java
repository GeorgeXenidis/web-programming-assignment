package com.unipi.e16095_assignment.dtos;

import com.unipi.e16095_assignment.enums.RoleEnum;

import java.io.Serializable;
import java.util.Objects;

public class LoginResponseDto implements Serializable {

    private Long id;
    private String username;
    private String email;
    private RoleEnum roleEnum;
    private boolean isAllowed;

    public LoginResponseDto() {
    }

    public LoginResponseDto(Long id, String username, String email, RoleEnum roleEnum, boolean isAllowed) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roleEnum = roleEnum;
        this.isAllowed = isAllowed;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }

    public boolean isAllowed() {
        return isAllowed;
    }

    public void setAllowed(boolean allowed) {
        isAllowed = allowed;
    }

    @Override
    public String toString() {
        return "LoginResponseDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", roleEnum=" + roleEnum +
                ", isAllowed=" + isAllowed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LoginResponseDto that = (LoginResponseDto) o;
        return isAllowed == that.isAllowed && Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(email, that.email) && roleEnum == that.roleEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, roleEnum, isAllowed);
    }
}
