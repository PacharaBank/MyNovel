package com.practice.mynovel.controllers;

import com.practice.mynovel.Dto.NovelDto;
import com.practice.mynovel.models.Genre;
import com.practice.mynovel.models.Novel;
import com.practice.mynovel.models.Status;
import com.practice.mynovel.services.GenreService;
import com.practice.mynovel.services.NovelService;
import com.practice.mynovel.services.StatusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FixNovelController {
    private final NovelService novelService;
    private final GenreService genreService;
    private final StatusService statusService;

    public FixNovelController(NovelService novelService, GenreService genreService,
                              StatusService statusService) {
        this.novelService = novelService;
        this.genreService = genreService;
        this.statusService = statusService;
    }
//add novel
    @ModelAttribute("novel")
    public NovelDto novelDto(){
        return new NovelDto();
    }

    @GetMapping("/new")
    public String getAddNovelForm(Model genreModel, Model statusModel){
        List<Genre> genreList = genreService.findAll();
        genreModel.addAttribute("genreSelect", genreList);
        List<Status> statusList = statusService.findAll();
        statusModel.addAttribute("statusSelect" , statusList);
        return "addNovelForm";
    }

    @PostMapping("/new")
    public String processAddNovel(@ModelAttribute("novel") NovelDto novelDto) {
        novelService.save(novelDto);
        return "success";
    }

    //update novel
    @GetMapping("/all/{id}/update")
    public String getUpdateNovelForm(@PathVariable Long id, Model novelModel,
                                     Model genreModel, Model statusModel){
        Novel novel = novelService.findById(id);
        novelModel.addAttribute("updateNovel", novel);
        List<Genre> genreList = genreService.findAll();
        genreModel.addAttribute("genreSelect", genreList);
        List<Status> statusList = statusService.findAll();
        statusModel.addAttribute("statusSelect" , statusList);
        return "updateNovelForm";
    }

    @PostMapping("/all/{id}/update")
    public String processUpdateNovel(@PathVariable Long id, @ModelAttribute("novel") NovelDto novelDto) {
        System.out.println("id is : "+ id);
        novelService.update(novelDto, id);
        return "success";
    }
}
