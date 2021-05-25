package com.practice.mynovel.services;

import com.practice.mynovel.models.Novel;

public interface NovelService extends CrudService<Novel, Long> {
    Novel findByName(String name);
    void deleteByName(String name);
}
