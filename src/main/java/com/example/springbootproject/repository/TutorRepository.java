package com.example.springbootproject.repository;

import com.example.springbootproject.entity.Tutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TutorRepository extends BaseRepository<Tutor, Integer>{

    @Query("SELECT t FROM Tutor t")
    Optional<List<Tutor>> list();
}
