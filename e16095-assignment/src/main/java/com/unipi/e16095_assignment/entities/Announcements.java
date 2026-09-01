package com.unipi.e16095_assignment.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "announcements")
public class Announcements {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "A_ID")
    private Integer id;

    @Column(name = "A_TITLE")
    private String title;

    @Column(name = "A_CONTENT")
    private String content;

    @Column(name = "A_CREATED_AT")
    private Date createdAt;

    @Column(name = "A_CREATED_BY")
    private Integer createdBy;

}
