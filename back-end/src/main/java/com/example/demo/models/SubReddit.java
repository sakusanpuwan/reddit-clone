package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "subReddits")
public class SubReddit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToMany
    @JoinTable(
            name = "users_subReddits",
            joinColumns = {@JoinColumn(name = "subReddit_id",nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "user_id",nullable = false)}
    )
    @JsonIgnoreProperties({"subReddits"})
    private List<User> users;

    @OneToMany(mappedBy = "subReddit",cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties({"subReddit"})
    private List<Post> posts;


    public SubReddit(String name){
        this.name = name;
        this.users = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public SubReddit(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void addPostToSubReddit(Post post){
        this.posts.add(post);
    }
}
