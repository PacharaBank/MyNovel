package com.practice.mynovel.controllers;

import com.practice.mynovel.models.Novel;
import com.practice.mynovel.services.NovelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AllNovelController {
    private final NovelService novelService;

    public AllNovelController(NovelService novelService) {
        this.novelService = novelService;
    }

    @GetMapping("/all")
    public String getIndex(Model allNovelModel){
        List<Novel> allNovelList = novelService.findAll();
        allNovelModel.addAttribute("allNovel", allNovelList);
        return "allNovel";
    }

    @GetMapping("/all/{id}")
    public String getOneNovel(Model NovelModel, @PathVariable("id") Long id){
        Novel novel = novelService.findById(id);
        if (novel != null){
            System.out.println("find the novel "+novel.getName());
            NovelModel.addAttribute("novel", novel);
        } else System.out.println("Can not find novel with id : " + id);
        return "showOneNovel";
    }

}
