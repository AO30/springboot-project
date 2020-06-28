package com.example.springbootproject.repository;

import com.example.springbootproject.entity.Course;
import com.example.springbootproject.entity.CourseElective;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends BaseRepository<Course,Integer> {
    @Query("select c from Course c")
    List<Course> list();
    @Query("select c.course from CourseElective c where c.student.id=:id")
    List<Course> list(@Param("id")Integer id);
    @Query("select c from Course c where c.teacher.user.id=:id")
    List<Course> listByTid(@Param("id")Integer id);
}
