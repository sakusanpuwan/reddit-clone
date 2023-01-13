package com.example.demo.services;

import com.example.demo.models.Post;
import com.example.demo.models.SubReddit;
import com.example.demo.models.User;
import com.example.demo.repositories.PostRepository;
import com.example.demo.repositories.SubRedditRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SubRedditRepository subRedditRepository;

    @Autowired
    PostRepository postRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User addUser(User user){
        userRepository.save(user);
        return user;
    }

    public Optional<User> getUserById(Long userId){
        return userRepository.findById(userId);
    }

    public User followSubReddit(Long userId,Long subRedditId){
        User targetUser = userRepository.findById(userId).get();
        SubReddit targetSubReddit = subRedditRepository.findById(subRedditId).get();
        targetUser.followSubReddit(targetSubReddit);
        userRepository.save(targetUser);
        targetSubReddit.addUser(targetUser);
        subRedditRepository.save(targetSubReddit);
        return targetUser;
    }

    public User addPost(Long userId, Long subRedditId,Post post){
        User targetUser = userRepository.findById(userId).get();
        SubReddit targetSubReddit = subRedditRepository.findById(subRedditId).get();
        post.setUser(targetUser);
        post.setSubReddit(targetSubReddit);
        postRepository.save(post);
        targetUser.addPost(post);
        userRepository.save(targetUser);
        targetSubReddit.addPostToSubReddit(post);
        subRedditRepository.save(targetSubReddit);
        return targetUser;
    }
}
