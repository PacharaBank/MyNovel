package com.practice.mynovel.services;

import com.practice.mynovel.dto.StatusDto;
import com.practice.mynovel.models.Status;

public interface StatusService extends CrudService<Status, StatusDto, Long>{
    Status findByName(String name);
}
