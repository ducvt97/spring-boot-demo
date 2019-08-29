package com.example.test.repository;

import com.example.test.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

    @Query("SELECT c FROM StudentEntity c WHERE c.name LIKE %:name%")
    List<CourseEntity> findByName(String name);

}
