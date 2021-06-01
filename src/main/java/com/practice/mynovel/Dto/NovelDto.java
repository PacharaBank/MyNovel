package com.practice.mynovel.Dto;

import com.practice.mynovel.models.Novel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NovelDto {
    private String name;
    private int totalChapter;
    private int rate;

    //details
    private String synopsis;
    private Novel novel;
    private String genre;
    private String status;
    //source
    private String sourceName;
    private String sourceUrl;
}
