package com.practice.mynovel.services;

import com.practice.mynovel.Dto.GenreDto;
import com.practice.mynovel.models.Genre;

public interface GenreService extends CrudService<Genre, GenreDto, Long> {
    Genre findByName(String name);
    Genre save(GenreDto genreDto);
}
