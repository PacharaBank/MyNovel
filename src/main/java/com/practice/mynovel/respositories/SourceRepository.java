package com.practice.mynovel.respositories;

import com.practice.mynovel.models.Source;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceRepository extends JpaRepository<Source, Long> {
    Source findByName(String name);
}
