package com.practice.mynovel.services.implement;

import com.practice.mynovel.models.Details;
import com.practice.mynovel.models.Novel;
import com.practice.mynovel.respositories.DetailsRepository;
import com.practice.mynovel.respositories.NovelRepository;
import com.practice.mynovel.services.DetailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {

    private final DetailsRepository detailsRepository;
    private final NovelRepository novelRepository;

    public DetailServiceImpl(DetailsRepository detailsRepository, NovelRepository novelRepository) {
        this.detailsRepository = detailsRepository;
        this.novelRepository = novelRepository;
    }

    @Override
    public List<Details> findAll() {
        return detailsRepository.findAll();
    }

    @Override
    public Details findById(Long aLong) {
        return detailsRepository.findById(aLong).orElse(null);
    }

    @Override
    public void update(Details object) {
        Novel novel = novelRepository.findByName(object.getNovel().getName());
        Details details = findById(object.getId());
        if (details == null) {
            details = new Details();
        }
        details.setNovel(novel);
        details.setSynopsis(object.getSynopsis());
        details.setStatus(object.getStatus());
        novel.setDetails(details);
        novelRepository.save(novel);
    }

    @Override
    public void delete(Details object) {
        detailsRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        detailsRepository.deleteById(id);
    }

    @Override
    public Details save(Details object) {
       return detailsRepository.save(object);
    }

    @Override
    public Details findByNovel(Novel novel) {
        return detailsRepository.findByNovel(novel);
    }
}
