package com.example.test.service;

import com.example.test.entity.CourseEntity;
import org.assertj.core.util.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.test.repository.CourseRepository;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseEntity addCourse(String name){
        try {
            CourseEntity courseEntity = new CourseEntity();
            courseEntity.setName(name);

            courseRepository.save(courseEntity);

            return courseEntity;
        } catch (Exception e){
            throw e;
        }
    }

    public List<CourseEntity> getCourseList(){
        try {
            return courseRepository.findAll();
        }catch (Exception e){
            throw e;
        }
    }

    public CourseEntity getByID(long id){
        try {
            return courseRepository.getOne(id);
        }catch (Exception e){
            throw e;
        }
    }

    public List<CourseEntity> searchByName(String name){
        try {
            if(name == null){
                name = "";
            }
            return courseRepository.findByName(name);
        }catch (Exception e){
            throw e;
        }
    }

    public Boolean deleteCourse(long id){
        try {
            courseRepository.deleteById(id);
            return true;
        } catch (Exception e){
            throw e;
        }
    }

    @VisibleForTesting
    void setCourseRepository(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }
}
