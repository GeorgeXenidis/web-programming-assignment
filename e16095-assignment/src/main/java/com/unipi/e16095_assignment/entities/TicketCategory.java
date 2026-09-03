package com.unipi.e16095_assignment.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ticket_categories")
public class TicketCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TCA_ID")
    private Integer id;

    @Column(name = "TCA_NAME")
    private String name;

    @Column(name = "TCA_DEFAULT_PRIORITY")
    private String defaultPriority;

    public TicketCategory() {
//        Empty Constructor
    }

    public TicketCategory(Integer id, String name, String defaultPriority) {
        this.id = id;
        this.name = name;
        this.defaultPriority = defaultPriority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefaultPriority() {
        return defaultPriority;
    }

    public void setDefaultPriority(String defaultPriority) {
        this.defaultPriority = defaultPriority;
    }

    @Override
    public String toString() {
        return "TicketCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", defaultPriority='" + defaultPriority + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TicketCategory that = (TicketCategory) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(defaultPriority, that.defaultPriority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, defaultPriority);
    }
}
