package com.practice.mynovel.respositories;

import com.practice.mynovel.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findByName(String name);
}
