package com.practice.mynovel.services.implement;

import com.practice.mynovel.Dto.NovelDto;
import com.practice.mynovel.models.*;
import com.practice.mynovel.respositories.DetailsRepository;
import com.practice.mynovel.respositories.GenreRepository;
import com.practice.mynovel.respositories.NovelRepository;
import com.practice.mynovel.respositories.StatusRepository;
import com.practice.mynovel.services.NovelService;
import com.practice.mynovel.services.SourceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NovelServiceImpl implements NovelService {
    private final NovelRepository novelRepository;
    private final DetailsRepository detailsRepository;
    private final GenreRepository genreRepository;
    private final StatusRepository statusRepository;
    private final SourceService sourceService;

    public NovelServiceImpl(NovelRepository novelRepository,
                            DetailsRepository detailsRepository,
                            GenreRepository genreRepository, StatusRepository statusRepository, SourceService sourceService) {
        this.novelRepository = novelRepository;
        this.detailsRepository = detailsRepository;
        this.genreRepository = genreRepository;
        this.statusRepository = statusRepository;
        this.sourceService = sourceService;
    }

    @Override
    public List<Novel> findAll() {
        return novelRepository.findAll();
    }

    @Override
    public Novel findById(Long aLong) {
        return novelRepository.findById(aLong).orElse(null);
    }

    @Override
    public void update(Novel object) {
        Novel novel = findById(object.getId());
        novel.setName(object.getName());
        novel.setRate(object.getRate());
        novel.setTotalChapter(object.getTotalChapter());
        novel.setSource(object.getSource());
        novelRepository.save(novel);
    }

    @Override
    public void delete(Novel object) {
        novelRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        novelRepository.deleteById(aLong);
    }

    @Override
    public Novel save(Novel object) {
        Source source = new Source();
        source.setName(object.getSource().getName());
        object.setSource(source);
        return novelRepository.save(object);
    }

    @Override
    public Novel save(NovelDto novelDto) {
        Novel novel = new Novel();
        novel.setName(novelDto.getName());
        novel.setRate(novelDto.getRate());
        novel.setTotalChapter(novelDto.getTotalChapter());

        Details details = new Details();
        details.setNovel(novel);
        details.setSynopsis(novelDto.getSynopsis());

        Status status = statusRepository.findByName(novelDto.getStatus());
        details.setStatus(status);
        Genre genre = genreRepository.findByName(novelDto.getName());
        details.getGenreList().add(genre);
        novel.setDetails(details);

        Source source = new Source();
        source.setName(novelDto.getSourceName());
        source.setUrl(novelDto.getSourceUrl());
        novel.setSource(source);
        return novelRepository.save(novel);
    }

    @Override
    public Novel findByName(String name) {
        return novelRepository.findByName(name);
    }

    @Override
    public void deleteByName(String name) {
        Novel novel = findByName(name);
        novelRepository.deleteById(novel.getId());
    }
}
