package com.example.demo.controllers;

import com.example.demo.models.Post;
import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<User> addNewUser(@RequestBody User user){
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PostMapping("/follow")
    public ResponseEntity<User> followSubReddit(@RequestParam Long userId,@RequestParam Long subRedditId){
        userService.followSubReddit(userId,subRedditId);
        User targetUser = userService.getUserById(userId).get();
        return new ResponseEntity<>(targetUser,HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<User> post(@RequestBody Post post,@RequestParam Long userId,@RequestParam Long subRedditId){
        User targetUser =  userService.addPost(userId,subRedditId,post);
        return new ResponseEntity<>(targetUser,HttpStatus.OK);
    }
}
