package com.example.springbootproject.repository;

import com.example.springbootproject.entity.Direction;
import com.example.springbootproject.entity.DirectionElective;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DirectionElectiveRepository extends BaseRepository<DirectionElective, Integer> {
    @Query("SELECT de FROM DirectionElective de WHERE de.student.id=:sid")
    Optional<List<DirectionElective>> list();
}
