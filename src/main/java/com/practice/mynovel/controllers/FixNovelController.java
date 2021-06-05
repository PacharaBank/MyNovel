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
    public String processAddNovel(NovelDto novelDto) {
        novelService.save(novelDto);
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
    public String processUpdateNovel(@PathVariable Long id, NovelDto oldNovelDto) {
        System.out.println("id of updated novel is : " + id);
        novelService.update(oldNovelDto, id);
        return "success";
    }
}
