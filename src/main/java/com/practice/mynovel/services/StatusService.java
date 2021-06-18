package com.practice.mynovel.services;

import com.practice.mynovel.models.Status;

public interface StatusService extends CrudService<Status, Long>{
    Status findByName(String name);
}
