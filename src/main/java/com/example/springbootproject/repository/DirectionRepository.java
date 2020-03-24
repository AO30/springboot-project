package com.example.springbootproject.repository;

import com.example.springbootproject.entity.Direction;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectionRepository extends BaseRepository<Direction, Integer> {
}
