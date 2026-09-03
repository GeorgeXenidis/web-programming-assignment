package com.unipi.e16095_assignment.dtos;

import com.unipi.e16095_assignment.enums.RoleEnum;

import java.io.Serializable;
import java.util.Objects;

public class LoginResponseDto implements Serializable {

    private String username;
    private RoleEnum roleEnum;
    private Boolean isApproved;

    public LoginResponseDto() {
//        Empty Constructor
    }

    public LoginResponseDto(String username, RoleEnum roleEnum, Boolean isApproved) {
        this.username = username;
        this.roleEnum = roleEnum;
        this.isApproved = isApproved;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public RoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    @Override
    public String toString() {
        return "LoginResponseDto{" +
                "username='" + username + '\'' +
                ", roleEnum=" + roleEnum +
                ", isApproved=" + isApproved +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LoginResponseDto that = (LoginResponseDto) o;
        return Objects.equals(username, that.username) && roleEnum == that.roleEnum && Objects.equals(isApproved, that.isApproved);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, roleEnum, isApproved);
    }
}
