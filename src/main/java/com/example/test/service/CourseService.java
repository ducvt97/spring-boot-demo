package com.example.test.service;

import com.example.test.entity.CourseEntity;

import java.util.List;

public interface CourseService {

    CourseEntity addCourse(String name);

    List<CourseEntity> getCourseList();

    CourseEntity getByID(long id);

    List<CourseEntity> searchByName(String name);

    Boolean deleteCourse(long id);

}
