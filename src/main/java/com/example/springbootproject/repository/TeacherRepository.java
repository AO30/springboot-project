package com.example.springbootproject.repository;

import com.example.springbootproject.entity.Teacher;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface TeacherRepository extends BaseRepository<Teacher, Integer>{

    @Query("from Teacher t where t.user.number=:teacherId")
    Teacher find(@Param("teacherId")Integer teacherId);

    @Modifying
    @Transactional
    @Query("update Teacher t set t.user.name=:name,t.password=:password where t.user.number=:teacherId")
    Integer update(@Param("name")String name,@Param("password")String password,@Param("teacherId")Integer teacherId);

}
