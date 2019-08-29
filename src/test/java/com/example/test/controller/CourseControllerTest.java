package com.example.test.controller;

import com.example.test.entity.CourseEntity;
import com.example.test.entity.StudentEntity;
import com.example.test.service.CourseService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CourseControllerTest {
    @InjectMocks
    private CourseController courseController;

    @Mock
    private CourseService courseService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        courseController.setCourseService(courseService);
    }

    @Test
    public void testAddCourse() {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(1);
        courseEntity.setName("10A1");

        when(courseService.addCourse(anyString())).thenReturn(courseEntity);

        ResponseEntity response = courseController.addCourse("10A1");
        CourseEntity actualCourseEntity = (CourseEntity) response.getBody();

        assertEquals(actualCourseEntity.getName(), courseEntity.getName());
    }

    @Test
    public void testDeleteCourse(){
        when(courseService.deleteCourse(anyLong())).thenReturn(true);

        ResponseEntity response = courseController.deleteCourse(1);
        Boolean result = (Boolean) response.getBody();

        assertEquals(result, true);
    }

    @Test
    public void testGetCourse() {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(1);
        courseEntity.setName("10A1");

        when(courseService.getByID(anyLong())).thenReturn(courseEntity);

        ResponseEntity response = courseController.getCourse(1);
        CourseEntity actualCourseEntity = (CourseEntity) response.getBody();

        assertEquals(actualCourseEntity.getName(), courseEntity.getName());
    }

    @Test
    public void testListCourse() {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(1);
        courseEntity.setName("10A1");

        List<CourseEntity> listCourse = new ArrayList<>();
        listCourse.add(courseEntity);

        when(courseService.getCourseList()).thenReturn(listCourse);

        ResponseEntity response = courseController.getCourseList();
        List<CourseEntity> actualCourse = (List<CourseEntity>) response.getBody();

        assertEquals(actualCourse.size(), listCourse.size());
    }

    @Test
    public void testSearchCourse() {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(1);
        courseEntity.setName("10A1");

        List<CourseEntity> courseList = new ArrayList<CourseEntity>();
        courseList.add(courseEntity);

        when(courseService.searchByName(anyString())).thenReturn(courseList);

        ResponseEntity response = courseController.searchByName("10A1");
        List<CourseEntity> actualCourse = (List<CourseEntity>) response.getBody();

        assertEquals(actualCourse.size(), courseList.size());
    }
}
