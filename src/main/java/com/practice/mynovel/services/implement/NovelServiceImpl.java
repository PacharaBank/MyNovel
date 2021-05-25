package com.practice.mynovel.services.implement;

import com.practice.mynovel.models.Novel;
import com.practice.mynovel.models.Source;
import com.practice.mynovel.respositories.NovelRepository;
import com.practice.mynovel.services.NovelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NovelServiceImpl implements NovelService {
    private final NovelRepository novelRepository;

    public NovelServiceImpl(NovelRepository novelRepository) {
        this.novelRepository = novelRepository;
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
    public void save(Novel object) {
        Source source = new Source();
        source.setName(object.getSource().getName());
        object.setSource(source);
        novelRepository.save(object);
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
