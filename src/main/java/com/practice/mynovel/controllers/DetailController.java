package com.practice.mynovel.controllers;

import com.practice.mynovel.models.Details;
import com.practice.mynovel.models.Novel;
import com.practice.mynovel.services.DetailService;
import com.practice.mynovel.services.GenreService;
import com.practice.mynovel.services.NovelService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/novel/{name}/detail")
public class DetailController {
    private final DetailService detailService;
    private final GenreService genreService;
    private final NovelService novelService;

    public DetailController(DetailService detailService, GenreService genreService, NovelService novelService) {
        this.detailService = detailService;
        this.genreService = genreService;
        this.novelService = novelService;
    }

    @GetMapping({"", "/"})
    public Details getDetail(@PathVariable String name){
        Novel novel = novelService.findByName(name);
        return detailService.findByNovel(novel);
    }

    @PostMapping("/add")
    public void addDetail(@PathVariable String name, @RequestBody Details details){
        Novel novel = novelService.findByName(name);
        details.setNovel(novel);
        novel.setDetails(details);
        novelService.save(novel);
    }

    @PutMapping("/update")
    public void updateDetail(@RequestBody Details details){
        detailService.update(details);
    }
}
