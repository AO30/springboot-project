package com.example.springbootproject.repository;

import com.example.springbootproject.entity.Elective;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectiveRepository extends BaseRepository<Elective, Integer> {
}
