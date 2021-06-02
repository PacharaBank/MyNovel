package com.practice.mynovel.services.implement;

import com.practice.mynovel.models.Source;
import com.practice.mynovel.respositories.SourceRepository;
import com.practice.mynovel.services.SourceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceServiceImpl implements SourceService {

    private final SourceRepository sourceRepository;

    public SourceServiceImpl(SourceRepository sourceRepository) {
        this.sourceRepository = sourceRepository;
    }

    @Override
    public List<Source> findAll() {
        return sourceRepository.findAll();
    }

    @Override
    public Source findById(Long aLong) {
        return sourceRepository.findById(aLong).orElse(null);
    }

    @Override
    public void update(Source object) {
        Source source = findById(object.getId());
        source.setName(object.getName());
        sourceRepository.save(source);
    }

    @Override
    public void delete(Source object) {
        sourceRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        sourceRepository.deleteById(aLong);
    }

    @Override
    public Source save(Source object) {
       return sourceRepository.save(object);
    }

    @Override
    public Source findByName(String name) {
        return sourceRepository.findByName(name);
    }
}
