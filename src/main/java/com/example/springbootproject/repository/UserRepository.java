package com.example.springbootproject.repository;

import com.example.springbootproject.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User, Integer> {
    @Query("from User u where u.number=:num")
    User find(@Param("num")Integer num);
}
