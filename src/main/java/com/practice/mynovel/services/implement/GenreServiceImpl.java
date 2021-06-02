package com.practice.mynovel.services.implement;

import com.practice.mynovel.models.Genre;
import com.practice.mynovel.respositories.GenreRepository;
import com.practice.mynovel.services.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre findById(Long aLong) {
        return genreRepository.findById(aLong).orElse(null);
    }

    @Override
    public void update(Genre object) {
    }

    @Override
    public void delete(Genre object) {
        genreRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        genreRepository.deleteById(aLong);
    }

    @Override
    public Genre save(Genre object) {
        Genre genre = genreRepository.findByName(object.getName());
        if (genre == null){//new genre
            genre = new Genre(object.getName());
        }
        return genreRepository.save(genre);
    }

    @Override
    public Genre findByName(String name) {
        return genreRepository.findByName(name);
    }
}
