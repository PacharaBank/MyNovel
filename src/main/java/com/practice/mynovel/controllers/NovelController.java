package com.practice.mynovel.controllers;

import com.practice.mynovel.models.Novel;
import com.practice.mynovel.services.NovelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/novel")
public class NovelController {
    private final NovelService novelService;

    public NovelController(NovelService novelService) {
        this.novelService = novelService;
    }

    @GetMapping({"", "/", "/all"})
    public List<Novel> getAllNovel() {
        return novelService.findAll();
    }

    @GetMapping("/{name}")
    public Novel getOneNovel(@PathVariable String name) {
        return novelService.findByName(name);
    }

    @PostMapping("/add")
    public void addNovel(@RequestBody Novel novel) {
        novelService.save(novel);
    }

    @DeleteMapping("/{name}/delete")
    public void deleteNovel(@PathVariable String name) {
        novelService.deleteByName(name);
    }

    @PutMapping("/{name}/update")
    public void updateNovel(@PathVariable String name, @RequestBody Novel novel) {
        novelService.update(novel);
    }
}
