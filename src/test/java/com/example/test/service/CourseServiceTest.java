package com.example.test.service;

import com.example.test.entity.CourseEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceTest {

    @Mock
    private CourseService courseService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetByClassID() {
        CourseEntity classEntity = new CourseEntity();

        when(courseService.getByID(anyLong())).thenReturn(classEntity);

        assertEquals(courseService.getByID(1).getName(), classEntity.getName());
    }

    @Test
    public void testGetCourseList() {
        CourseEntity classEntity = new CourseEntity();
        classEntity.setId(1);
        classEntity.setName("10A1");

        List<CourseEntity> courseList = new ArrayList<>();
        courseList.add(classEntity);

        when(courseService.getCourseList()).thenReturn(courseList);

        assertEquals(courseService.getCourseList().size(), courseList.size());
    }

    @Test
    public void testSearchByName(){
        CourseEntity classEntity = new CourseEntity();
        classEntity.setId(1);
        classEntity.setName("10A1");

        List<CourseEntity> courseList = new ArrayList<>();
        courseList.add(classEntity);

        when(courseService.searchByName(anyString())).thenReturn(courseList);

        assertEquals(courseService.searchByName("10A1").size(), courseList.size());
    }
}
