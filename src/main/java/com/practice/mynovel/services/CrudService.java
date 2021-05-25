package com.practice.mynovel.services;

import java.util.List;

public interface CrudService<T, ID> {
    List<T> findAll();
    T findById(ID id);
    void update(T object);
    void delete(T object);
    void deleteById(ID id);
    void save(T object);
}
