package com.practice.mynovel.services.implement;

import com.practice.mynovel.Dto.NovelDto;
import com.practice.mynovel.models.*;
import com.practice.mynovel.respositories.NovelRepository;
import com.practice.mynovel.services.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NovelServiceImpl implements NovelService {
    private final NovelRepository novelRepository;
    private final DetailService detailService;
    private final GenreService genreService;
    private final StatusService statusService;
    private final SourceService sourceService;

    public NovelServiceImpl(NovelRepository novelRepository,
                            DetailService detailService,
                            GenreService genreService,
                            StatusService statusService,
                            SourceService sourceService) {
        this.novelRepository = novelRepository;
        this.detailService = detailService;
        this.genreService = genreService;
        this.statusService = statusService;
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

        Source source = new Source(novelDto.getSourceName(), novelDto.getSourceUrl());
        source.setNovel(novel);
        novel.setSource(source);

        Status status = statusService.findByName(novelDto.getStatus());
        details.setStatus(status);

        List<Genre> genreList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Genre genre = genreService.findByName(novelDto.getGenreList().get(i).getName());
            genreList.add(genre);
        }
        details.setGenreList(genreList);

        details.setNovel(novel);
        novel.setDetails(details);

        return novelRepository.save(novel);
    }

    @Override
    public Novel update(NovelDto novelDto, Long id) {
        Optional<Novel> novelOptional = novelRepository.findById(id);

        Novel novel = novelOptional.get();
        novel.setName(novelDto.getName());
        novel.setRate(novelDto.getRate());
        novel.setTotalChapter(novelDto.getTotalChapter());

        Details details = detailService.findById(novel.getDetails().getId());
        details.setSynopsis(novelDto.getSynopsis());

        Source source = sourceService.findById(novel.getSource().getId());
        source.setName(novelDto.getSourceName());
        source.setUrl(novelDto.getSourceUrl());
        source.setNovel(novel);
        novel.setSource(source);

        Status status = statusService.findByName(novelDto.getStatus());
        details.setStatus(status);

        List<Genre> genreList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Genre genre = genreService.findByName(novelDto.getGenreList().get(i).getName());
            if (genreList.contains(genre)){
                genreList.add(genreService.findByName("-"));
            }else genreList.add(genre);
        }
        details.setGenreList(genreList);

        details.setNovel(novel);
        novel.setDetails(details);

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
