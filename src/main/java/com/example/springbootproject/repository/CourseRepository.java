package com.example.springbootproject.repository;

import com.example.springbootproject.entity.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends BaseRepository<Course,Integer> {
}
