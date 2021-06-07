package com.practice.mynovel.services;

import com.practice.mynovel.dto.SourceDto;
import com.practice.mynovel.models.Source;

public interface SourceService extends CrudService<Source, SourceDto, Long> {
    Source findByName(String name);
}
