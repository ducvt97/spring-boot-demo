package com.example.test.controller;

import com.example.test.entity.CourseEntity;
import com.example.test.service.CourseService;
import org.assertj.core.util.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/add")
    public ResponseEntity<CourseEntity> addCourse(@RequestParam(name = "name", required = true) String name){
        try {
            return ResponseEntity.ok().body(courseService.addCourse(name));
        }catch (Exception e){
            throw e;
        }
    }

    @RequestMapping("/list")
    public ResponseEntity<List<CourseEntity>> getCourseList(){
        try {
            return ResponseEntity.ok().body(courseService.getCourseList());
        }catch (Exception e){
            throw e;
        }
    }

    @RequestMapping("/search")
    public ResponseEntity<List<CourseEntity>> searchByName(@RequestParam(name = "name", required = false) String name){
        try {
            if (name.isEmpty()){
                return ResponseEntity.ok().body(courseService.getCourseList());
            }
            return ResponseEntity.ok().body(courseService.searchByName(name));
        }catch (Exception e){
            throw e;
        }
    }

    @RequestMapping("/get/{id}")
    public ResponseEntity<CourseEntity> getCourse(@PathVariable(name = "id", required = false) long id){
        try {
            return ResponseEntity.ok().body(courseService.getByID(id));
        }
        catch (Exception e){
            throw e;
        }
    }

    @RequestMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteCourse(@PathVariable(name = "id", required = false) long id){
        try {
            return ResponseEntity.ok().body(courseService.deleteCourse(id));
        }
        catch (Exception e){
            throw e;
        }
    }

    // Only for testing
    @VisibleForTesting
    void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }
}
