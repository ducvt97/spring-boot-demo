package com.example.test.service;

import com.example.test.entity.StudentEntity;

import java.util.List;

public interface StudentService {

    List<StudentEntity> getStudentList();

    StudentEntity getStudent(long id);

    StudentEntity addStudent(String name, String phone);

    boolean deleteStudent(long id);

    List<StudentEntity> findByNameAndPhone(String name, String phone);
}
