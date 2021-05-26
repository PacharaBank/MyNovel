package com.practice.mynovel.controllers;

import com.practice.mynovel.services.NovelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogInController {

    private final NovelService novelService;

    public LogInController(NovelService novelService) {
        this.novelService = novelService;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/index2")
    public String index2(){
        return "index2";
    }


}
