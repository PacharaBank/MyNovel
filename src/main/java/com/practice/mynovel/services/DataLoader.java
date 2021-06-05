package com.practice.mynovel.services;

import com.practice.mynovel.models.Details;
import com.practice.mynovel.models.Genre;
import com.practice.mynovel.models.Novel;
import com.practice.mynovel.models.Status;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

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

        Genre action = new Genre("Action");
        Genre adventure = new Genre("Adventure");
        Genre fantasy = new Genre("Fantasy");
        genreService.save(action);
        genreService.save(adventure);
        genreService.save(fantasy);

        Status finished = new Status("Finished");
        Status ongoing = new Status("Ongoing");
        Status abandoned = new Status("Abandoned");
        statusService.save(finished);
        statusService.save(ongoing);
        statusService.save(abandoned);

//        Source webNovel = new Source("WebNovel",
//                "https://www.webnovel.com/book/release-that-witch_7931338406001705");
//        releaseThatWitch.setSource(webNovel);

        Details releaseWithDetail = new Details();
        releaseWithDetail.setSynopsis(
                "Roland, a prince regarded as hopeless by his own father and assigned to " +
                        "the worst fief, spends his time developing a poor and backward town " +
                        "into a strong and modern city, while fighting against his siblings" +
                        " for the throne and absolute control over the kingdom. Join Roland" +
                        " as he befriends and allies with witches and, through fighting and" +
                        " even farming, pushes back invaders coming from the realm of evil.");
        releaseWithDetail.setGenreList(Arrays.asList(action, adventure, fantasy));
        releaseWithDetail.setStatus(finished);

        releaseWithDetail.setNovel(releaseThatWitch);
        releaseThatWitch.setDetails(releaseWithDetail);

        novelService.save(releaseThatWitch);
    }
}
