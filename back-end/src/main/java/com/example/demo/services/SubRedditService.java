package com.example.demo.services;

import com.example.demo.models.SubReddit;
import com.example.demo.repositories.SubRedditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubRedditService {

    @Autowired
    SubRedditRepository subRedditRepository;

    public List<SubReddit> getAllSubReddits(){
        return subRedditRepository.findAll();
    }

    public SubReddit addSubReddit(SubReddit subReddit){
        subRedditRepository.save(subReddit);
        return subReddit;
    }
}
