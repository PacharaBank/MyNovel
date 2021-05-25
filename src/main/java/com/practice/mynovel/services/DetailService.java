package com.practice.mynovel.services;

import com.practice.mynovel.models.Details;
import com.practice.mynovel.models.Novel;

public interface DetailService extends CrudService<Details, Long>{
    Details findByNovel(Novel novel);
}
