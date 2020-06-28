package com.example.springbootproject.repository;

import com.example.springbootproject.entity.Direction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DirectionRepository extends BaseRepository<Direction, Integer> {
    @Query("select d from Direction d")
    List<Direction> list();
    @Query("select d.direction from DirectionElective d where d.student.id=:id")
    List<Direction> list(@Param("id")Integer id);
    @Query("select d from Direction d where d.teacher.id=:id")
    List<Direction> listByteacherId(@Param("id")Integer id);
}
