package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String postTitle;

    @Column
    private String postBody;

    @Column
    private String postImage;

    @Column
    private Integer upvotes;

    @ManyToOne
    @JoinColumn(name = "name")
    @JsonIgnoreProperties({"posts","users"})
    private SubReddit subReddit;

    @ManyToMany
    @JoinTable(
            name = "users_likedPosts",
            joinColumns = {@JoinColumn(name = "likedPost_id",nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "user_id",nullable = false)}
    )
    @JsonIgnore
    private List<User> likedUsers;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"posts"})
    private User user;

    public Post(String postTitle, String postBody, String postImage, User user,SubReddit subReddit){
        this.postTitle = postTitle;
        this.postBody = postBody;
        this.postImage = postImage;
        this.upvotes = 0;
        this.user = user;
        this.subReddit = subReddit;
        this.likedUsers = new ArrayList<>();
    }

    public Post(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

    public SubReddit getSubReddit() {
        return subReddit;
    }

    public void setSubReddit(SubReddit subReddit) {
        this.subReddit = subReddit;
    }

    public List<User> getLikedUsers() {
        return likedUsers;
    }

    public void setLikedUsers(List<User> likedUsers) {
        this.likedUsers = likedUsers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
