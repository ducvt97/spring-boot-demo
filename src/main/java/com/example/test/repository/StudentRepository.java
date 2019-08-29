package com.example.test.repository;

import com.example.test.entity.StudentEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public interface StudentRepository extends JpaRepository<StudentEntity, Long>{
        @Query("SELECT s FROM StudentEntity s WHERE s.name LIKE %:name%")
        List<StudentEntity> findByName(String name);

        @Query("SELECT s FROM StudentEntity s WHERE s.phone LIKE %:phone%")
        List<StudentEntity> findByPhone(String phone);

        @Query("SELECT s FROM StudentEntity s WHERE s.name LIKE %:name% AND s.phone LIKE %:phone%")
        List<StudentEntity> findByNameAndPhone(String name, String phone);
}