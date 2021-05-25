package com.practice.mynovel.respositories;

import com.practice.mynovel.models.Novel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NovelRepository extends JpaRepository<Novel, Long> {
    Novel findByName(String name);
}
