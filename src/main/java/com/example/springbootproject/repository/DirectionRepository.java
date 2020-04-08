package com.example.springbootproject.repository;

import com.example.springbootproject.entity.Direction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DirectionRepository extends BaseRepository<Direction, Integer> {
    @Query("SELECT d FROM Direction d")
    Optional<List<Direction>> list();
}
