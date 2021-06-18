package com.practice.mynovel.dto;

import com.practice.mynovel.models.Genre;
import com.practice.mynovel.models.Novel;
import com.practice.mynovel.services.GenreService;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class NovelDto {
    private final GenreService genreService;
    private String name;
    private String totalChapter;
    private String rate;
    private String photosSource;

    //details
    private String synopsis;
    private Novel novel;
    private List<Genre> genreList = new ArrayList<>();
    private String status;

    //source
    private String sourceName;
    private String sourceUrl;

    public NovelDto(GenreService genreService) {
        this.genreService = genreService;
    }

    public void addGenre(Genre genre) {
        this.genreList.add(genre);
    }

    public void setNovelValue(Novel setNovel){
        this.name = setNovel.getName();
        this.totalChapter = setNovel.getTotalChapter();
        this.rate = setNovel.getRate();
        this.photosSource = setNovel.getPhotosSource();
        this.synopsis = setNovel.getDetails().getSynopsis();
        this.novel = setNovel;
        this.genreList = setNovel.getDetails().getGenreList();
        while (genreList.size() < 3) {
            Genre noGenre = this.genreService.findByName("-");
            genreList.add(noGenre);
        }
        this.status = setNovel.getDetails().getStatus().toString();
        this.sourceName = setNovel.getSource().getName();
        this.sourceUrl = getNovel().getSource().getUrl();
    }
}
