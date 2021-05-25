package com.practice.mynovel.respositories;

import com.practice.mynovel.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
