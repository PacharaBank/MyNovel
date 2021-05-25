package com.practice.mynovel.services;

import com.practice.mynovel.models.Details;
import com.practice.mynovel.models.Genre;
import com.practice.mynovel.models.Novel;
import com.practice.mynovel.models.Source;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;


public class DataLoader implements CommandLineRunner {
    private final NovelService novelService;
    private final DetailService detailService;
    private final SourceService sourceService;
    private final GenreService genreService;

    public DataLoader(NovelService novelService, DetailService detailService,
                      SourceService sourceService, GenreService genreService) {
        this.novelService = novelService;
        this.detailService = detailService;
        this.sourceService = sourceService;
        this.genreService = genreService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {

        Novel releaseThatWitch = new Novel();
        releaseThatWitch.setName("Release That Witch");
        releaseThatWitch.setRate(5);
        releaseThatWitch.setTotalChapter(500);

        Genre action = new Genre("Action");
        Genre adventure = new Genre("Adventure");
        Genre fantasy = new Genre("Fantasy");

        Source webNovel = new Source("WebNovel");
        releaseThatWitch.setSource(webNovel);

        Details releaseWithDetail = new Details();
        releaseWithDetail.setSynopsis(
                "Roland, a prince regarded as hopeless by his own father and assigned to " +
                        "the worst fief, spends his time developing a poor and backward town " +
                        "into a strong and modern city, while fighting against his siblings" +
                        " for the throne and absolute control over the kingdom. Join Roland" +
                        " as he befriends and allies with witches and, through fighting and" +
                        " even farming, pushes back invaders coming from the realm of evil.");
        releaseWithDetail.setGenreList(Arrays.asList(action, adventure, fantasy));

        releaseWithDetail.setNovel(releaseThatWitch);
        releaseThatWitch.setDetails(releaseWithDetail);

        novelService.save(releaseThatWitch);
    }
}
