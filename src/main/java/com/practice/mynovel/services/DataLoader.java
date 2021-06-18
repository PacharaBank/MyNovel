package com.practice.mynovel.services;

import com.practice.mynovel.models.Details;
import com.practice.mynovel.models.Genre;
import com.practice.mynovel.models.Novel;
import com.practice.mynovel.models.Status;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private final NovelService novelService;
    private final DetailService detailService;
    private final SourceService sourceService;
    private final GenreService genreService;
    private final StatusService statusService;

    public DataLoader(NovelService novelService, DetailService detailService,
                      SourceService sourceService, GenreService genreService,
                      StatusService statusService) {
        this.novelService = novelService;
        this.detailService = detailService;
        this.sourceService = sourceService;
        this.genreService = genreService;
        this.statusService = statusService;
    }

    @Override
    public void run(String... args) throws Exception {
        genreService.save(new Genre("Action"));
        genreService.save(new Genre("Adventure"));
        genreService.save(new Genre("Fantasy"));
        genreService.save(new Genre("-"));

        statusService.save(new Status("Finished"));
        statusService.save(new Status("Ongoing"));
        statusService.save(new Status("Abandoned"));
//        loadData();
    }

    private void loadData() {
        Novel releaseThatWitch = new Novel();
        releaseThatWitch.setName("Release That Witch");
        releaseThatWitch.setRate("5");
        releaseThatWitch.setTotalChapter("500");
        releaseThatWitch.setPhotosSource("/images/releaseThatWitch.jpg");
        Details releaseWithDetail = new Details();
        releaseWithDetail.setSynopsis(
                "Roland, a prince regarded as hopeless by his own father and assigned to " +
                        "the worst fief, spends his time developing a poor and backward town " +
                        "into a strong and modern city, while fighting against his siblings" +
                        " for the throne and absolute control over the kingdom. Join Roland" +
                        " as he befriends and allies with witches and, through fighting and" +
                        " even farming, pushes back invaders coming from the realm of evil.");
        List<Genre> genreList = new ArrayList<>();
        genreList.add(genreService.findByName("Action"));
        releaseWithDetail.setGenreList(genreList);
        releaseWithDetail.setStatus(statusService.findByName("Finished"));

        releaseWithDetail.setNovel(releaseThatWitch);
        releaseThatWitch.setDetails(releaseWithDetail);

        novelService.save(releaseThatWitch);
    }
}
