package com.example.springbootproject.repository;

import com.example.springbootproject.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends BaseRepository<Student, Integer> {
    @Query("from Student s where  s.user.number=:studentId")
    Student find(@Param("studentId")Integer studentId);
}
