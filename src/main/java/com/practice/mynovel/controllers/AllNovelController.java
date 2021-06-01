package com.practice.mynovel.controllers;

import com.practice.mynovel.models.Novel;
import com.practice.mynovel.services.NovelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AllNovelController {
    private final NovelService novelService;

    public AllNovelController(NovelService novelService) {
        this.novelService = novelService;
    }


    @GetMapping("/all")
    public String showIndex(ModelMap model, ModelMap allNovel){
        Novel novel = novelService.findByName("Release That Witch");
        List<Novel> allNovelList = novelService.findAll();
        allNovel.addAttribute("allNovel", allNovelList);
        model.addAttribute("novel", novel);
        return "allNovel";
    }



}
