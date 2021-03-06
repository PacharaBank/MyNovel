package com.practice.mynovel.controllers;


import com.practice.mynovel.dto.NovelDto;
import com.practice.mynovel.models.Genre;
import com.practice.mynovel.models.Novel;
import com.practice.mynovel.models.Status;
import com.practice.mynovel.services.GenreService;
import com.practice.mynovel.services.NovelService;
import com.practice.mynovel.services.StatusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class NovelController {
    private final NovelService novelService;
    private final GenreService genreService;
    private final StatusService statusService;

    public NovelController(NovelService novelService, GenreService genreService,
                           StatusService statusService) {
        this.novelService = novelService;
        this.genreService = genreService;
        this.statusService = statusService;
    }

    @GetMapping("/all")
    public String getIndex(Model allNovelModel) {
        List<Novel> allNovelList = novelService.findAll();
        allNovelModel.addAttribute("allNovel", allNovelList);
        return "allNovel";
    }

    @GetMapping("/all/{id}")
    public String getOneNovel(Model NovelModel, @PathVariable("id") Long id) {
        Novel novel = novelService.findById(id);
        if (novel != null) {
            System.out.println("find the novel : " + novel.getName());
            System.out.println("Image source : " + novel.getPhotosImagePath());
            NovelModel.addAttribute("novel", novel);
        } else System.out.println("Can not find novel with id : " + id);
        return "showOneNovel";
    }

    //add new novel
    @GetMapping("/new")
    public String getAddNovelForm(Model genreModel, Model statusModel, Model novelModel) {
        NovelDto novelDto = new NovelDto(genreService);
        for (int i = 0; i < 3; i++) {
            novelDto.addGenre(new Genre());
        }
        novelModel.addAttribute("novel", novelDto);
        List<Genre> genreList = genreService.findAll();
        genreModel.addAttribute("genreSelect", genreList);
        List<Status> statusList = statusService.findAll();
        statusModel.addAttribute("statusSelect", statusList);
        return "addNovelForm";
    }

    @PostMapping("/new")
    public String processAddNovel(NovelDto novelDto,
                                  @RequestParam("image")MultipartFile multipartFile) throws IOException {
        novelService.save(novelDto, multipartFile);
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String successPage(){
        return "success";
    }

    //update novel
    @GetMapping("/all/{id}/update")
    public String getUpdateNovelForm(@PathVariable Long id,
                                     Model genreModel, Model statusModel, Model novelDtoModel) {

        Novel oldNovel = novelService.findById(id);
        NovelDto oldNovelDto = new NovelDto(genreService);
        oldNovelDto.setNovelValue(oldNovel);
        novelDtoModel.addAttribute("oldNovelDto", oldNovelDto);
        List<Genre> genreList = genreService.findAll();
        genreModel.addAttribute("genreSelect", genreList);
        List<Status> statusList = statusService.findAll();
        statusModel.addAttribute("statusSelect", statusList);
        return "updateNovelForm";
    }

    @PostMapping("/all/{id}/update")
    public String processUpdateNovel(@PathVariable Long id, NovelDto oldNovelDto,
                                     @RequestParam("image")MultipartFile multipartFile) throws IOException{
        System.out.println("id of updated novel is : " + id);
        novelService.update(oldNovelDto, id, multipartFile);
        return "success";
    }
}
