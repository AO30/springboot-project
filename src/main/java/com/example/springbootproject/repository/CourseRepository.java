package com.example.springbootproject.repository;

import com.example.springbootproject.entity.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends BaseRepository<Course,Integer> {
    @Query("SELECT  c FROM Course c")
    Optional<List<Course>> list();
}
