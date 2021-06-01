package com.practice.mynovel.Dto;

import com.practice.mynovel.models.Novel;
import com.practice.mynovel.models.Source;
import com.practice.mynovel.models.Status;
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
    private Source source;

    //details
    private String synopsis;
    private Novel novel;
    private String genre;
    //
    private Status status;
}
