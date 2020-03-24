package com.example.springbootproject.repository;

import com.example.springbootproject.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends BaseRepository<Student, Integer> {
    Student findByStudentID(int studentID);
}
