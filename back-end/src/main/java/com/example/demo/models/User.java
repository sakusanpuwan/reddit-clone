package com.example.demo.models;

import jakarta.persistence.*;

import java.util.List;

// Every class that is to use JPA functionality must get the @Entity annotation
// JPA - Jakarta Persistence API is an ORM
// ORM = Object Relational Mapper - help us map objects into databases
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private String name;

    @Column
    private String profilePicture;

    @ManyToMany
    @JoinTable(
            name = "users_subReddits",
            joinColumns = {@JoinColumn(name = "user_id",nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "subReddit_id",nullable = false)}
    )
    private List<SubReddit> subReddits;




}
