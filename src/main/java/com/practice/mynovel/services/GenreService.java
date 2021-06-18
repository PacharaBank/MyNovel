package com.practice.mynovel.services;

import com.practice.mynovel.dto.GenreDto;
import com.practice.mynovel.models.Genre;

public interface GenreService extends CrudService<Genre, Long> {
    Genre findByName(String name);
    Genre save(GenreDto genreDto);
}
