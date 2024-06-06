package com.example.cgitask.api.controller;

import com.example.cgitask.api.model.WordFrequency;
import com.example.cgitask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService =userService;
    }

    @PostMapping("/count")
    public String getString(@RequestBody String count) {
       return userService.getWordFrequency(count);
    }

    }
