package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.ArrayList;
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
    @JsonIgnoreProperties({"users"})
    private List<SubReddit> subReddits;

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties({"user"})
    private List<Post> posts;

    @ManyToMany
    @JoinTable(
            name = "users_likedPosts",
            joinColumns = {@JoinColumn(name = "user_id",nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "likedPost_id",nullable = false)}
    )
    @JsonIgnoreProperties("user")
    private List<Post> likedPosts;

    public User(String name, String profilePicture) {
        this.name = name;
        this.profilePicture = profilePicture;
        this.posts = new ArrayList<>();
        this.likedPosts = new ArrayList<>();
        this.subReddits = new ArrayList<>();
    }

    public User(){

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public List<SubReddit> getSubReddits() {
        return subReddits;
    }

    public void setSubReddits(List<SubReddit> subReddits) {
        this.subReddits = subReddits;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getLikedPosts() {
        return likedPosts;
    }

    public void setLikedPosts(List<Post> likedPosts) {
        this.likedPosts = likedPosts;
    }

    public void addPost(Post post){this.posts.add(post);}

    public void likePost(Post post){
        this.likedPosts.add(post);
    }

    public void followSubReddit(SubReddit subReddit){
        this.subReddits.add(subReddit);
    }
}
