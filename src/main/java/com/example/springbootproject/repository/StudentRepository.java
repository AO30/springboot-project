package com.example.springbootproject.repository;

import com.example.springbootproject.entity.Student;
import com.example.springbootproject.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends BaseRepository<Student, Integer> {
    @Query("SELECT s FROM Student s WHERE s.studentID=:studentID")
    Optional<Student> findByStudentID(@Param("studentID") int studentID);

    @Query("SELECT s FROM Student s")
    Optional<List<Student>> list();
}
