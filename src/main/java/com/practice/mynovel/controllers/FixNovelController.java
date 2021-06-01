package com.practice.mynovel.controllers;

import com.practice.mynovel.Dto.NovelDto;
import com.practice.mynovel.models.Genre;
import com.practice.mynovel.services.GenreService;
import com.practice.mynovel.services.NovelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FixNovelController {
    private final NovelService novelService;
    private final GenreService genreService;

    public FixNovelController(NovelService novelService, GenreService genreService) {
        this.novelService = novelService;
        this.genreService = genreService;
    }
//add novel
    @ModelAttribute("novel")
    public NovelDto novelDto(){
        return new NovelDto();
    }

    @GetMapping("/new")
    public String getAddNovelForm(Model model){
        List<Genre> genreList = genreService.findAll();
        model.addAttribute("genreSelect", genreList);
        return "addNovelForm";
    }

    @PostMapping("/new")
    public String addNovel(@ModelAttribute("novel") NovelDto novelDto) {
        novelService.save(novelDto);
        return "success";
    }
}
