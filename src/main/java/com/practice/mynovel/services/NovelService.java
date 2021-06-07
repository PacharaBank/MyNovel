package com.practice.mynovel.services;

import com.practice.mynovel.dto.NovelDto;
import com.practice.mynovel.models.Novel;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface NovelService extends CrudService<Novel, NovelDto, Long> {
    Novel findByName(String name);
    void deleteByName(String name);
    Novel save(NovelDto novelDto, MultipartFile multipartFile) throws IOException;
    Novel update(NovelDto novelDto, Long id, MultipartFile multipartFile) throws IOException;
}
