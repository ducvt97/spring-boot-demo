package com.example.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    @Autowired
    private CourseController courseController() {return new CourseController();}

    @Autowired
    private StudentController studentController() {return new StudentController();}

}