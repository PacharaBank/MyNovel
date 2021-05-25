package com.practice.mynovel.respositories;

import com.practice.mynovel.models.Details;
import com.practice.mynovel.models.Novel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailsRepository extends JpaRepository<Details, Long> {
    Details findByNovel(Novel novel);
}
