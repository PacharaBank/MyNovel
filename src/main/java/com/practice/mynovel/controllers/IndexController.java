package com.practice.mynovel.controllers;

import com.practice.mynovel.models.Novel;
import com.practice.mynovel.services.NovelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping({"/", "/index"})
    public String showIndex(Model model) {
        Novel novel = novelService.findByName("Release That Witch");
        if (novel != null) {
            model.addAttribute("novel", novel);
        }
        return "index";
    }

    @PostMapping("/search")
    public String processSearch(@RequestParam(required = true) String novelName
            , Model model) {
        System.out.println("searching for novel : " + novelName);
        if (novelName.equals("")){
            return "redirect:";
        }
        List<Novel> novelList = novelService.findAllByNameLike("%" + novelName + "%");
        if (novelList.isEmpty()) {
            System.out.println("cant find novel : refresh page");
            return "redirect:";
        } else if (novelList.size() == 1) {
            System.out.println("found 1 novel : " + novelList.get(0).getName());
            return "redirect:/all/" + novelList.get(0).getId();
        } else {
            System.out.println("found List of novel : ");
            novelList.stream().map(n -> n.getName()).forEach(System.out::println);
            model.addAttribute("searchList", novelList);
            return "searchNovel";
        }
    }


}
