package com.example.demo.controllers;

import com.example.demo.models.SubReddit;
import com.example.demo.services.SubRedditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subreddit")
public class SubRedditController {

    @Autowired
    SubRedditService subRedditService;

    @PostMapping
    public ResponseEntity<SubReddit> addNewSubReddit(@RequestBody SubReddit subReddit){
        SubReddit newSubReddit = subRedditService.addSubReddit(subReddit);
        return new ResponseEntity<>(newSubReddit, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SubReddit>> getAllSubReddits(){
        List<SubReddit> subReddits = subRedditService.getAllSubReddits();
        return new ResponseEntity<>(subReddits,HttpStatus.OK);
    }

}
