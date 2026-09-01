package com.unipi.e16095_assignment.entities;

import com.unipi.e16095_assignment.enums.RoleEnum;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "R_ID")
    private Integer id;

    @Column(name = "R_NAME")
    private RoleEnum name;

    public Roles() {
//        Empty Constructor
    }

    public Roles(Integer id, RoleEnum name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoleEnum getName() {
        return name;
    }

    public void setName(RoleEnum name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Roles roles = (Roles) o;
        return Objects.equals(id, roles.id) && name == roles.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
