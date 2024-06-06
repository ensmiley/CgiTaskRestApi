package com.example.cgitask.service;

import com.example.cgitask.api.controller.UserController;
import com.example.cgitask.api.model.WordFrequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

import java.util.Map;

@Service
public class UserService {

    public String getWordFrequency(@RequestParam String words) {
        WordFrequency textString = new WordFrequency(words);
        return textString.count();

    }
}
