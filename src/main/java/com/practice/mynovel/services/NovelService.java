package com.practice.mynovel.services;

import com.practice.mynovel.Dto.NovelDto;
import com.practice.mynovel.models.Novel;

public interface NovelService extends CrudService<Novel, NovelDto, Long> {
    Novel findByName(String name);
    void deleteByName(String name);
    Novel save(NovelDto novelDto);
}
