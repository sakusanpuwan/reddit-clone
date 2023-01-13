package com.example.demo.components;

import com.example.demo.models.SubReddit;
import com.example.demo.models.User;
import com.example.demo.repositories.SubRedditRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SubRedditRepository subRedditRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user1 = new User("Sakusan","URL");
        userRepository.save(user1);

        SubReddit subReddit1 = new SubReddit("memes");
        subRedditRepository.save(subReddit1);
    }

}
