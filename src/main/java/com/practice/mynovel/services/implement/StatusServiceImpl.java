package com.practice.mynovel.services.implement;

import com.practice.mynovel.models.Status;
import com.practice.mynovel.respositories.StatusRepository;
import com.practice.mynovel.services.StatusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
    private final StatusRepository statusRepository;

    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public Status findById(Long aLong) {
        return statusRepository.findById(aLong).orElse(null);
    }

    @Override
    public void update(Status object) {
        statusRepository.save(object);
    }

    @Override
    public void delete(Status object) {
        statusRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        statusRepository.deleteById(aLong);
    }

    @Override
    public Status save(Status object) {
        return statusRepository.save(object);
    }
}
