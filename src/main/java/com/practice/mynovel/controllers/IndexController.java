package com.practice.mynovel.controllers;

import com.practice.mynovel.models.Novel;
import com.practice.mynovel.services.NovelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    private final NovelService novelService;

    public IndexController(NovelService novelService) {
        this.novelService = novelService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping({"/", "/index", ""})
    public String showIndex(ModelMap model, ModelMap allNovel){
        Novel novel = novelService.findByName("Release That Witch");
        if (novel != null) {
            List<Novel> allNovelList = novelService.findAll();
            allNovel.addAttribute("allNovel", allNovelList);
            model.addAttribute("novel", novel);
        }
        return "index";
    }


}
