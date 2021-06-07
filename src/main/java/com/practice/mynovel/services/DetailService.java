package com.practice.mynovel.services;

import com.practice.mynovel.dto.DetailDto;
import com.practice.mynovel.models.Details;
import com.practice.mynovel.models.Novel;

public interface DetailService extends CrudService<Details, DetailDto, Long>{
    Details findByNovel(Novel novel);
}
