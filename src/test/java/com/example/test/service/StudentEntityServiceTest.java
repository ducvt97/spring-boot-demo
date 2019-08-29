package com.example.test.service;

import com.example.test.controller.StudentController;
import com.example.test.entity.StudentEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StudentEntityServiceTest {

    @Mock
    private StudentService studentService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetStudent() {

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(1);
        studentEntity.setName("Duc");

        when(studentService.getStudent(anyLong())).thenReturn(studentEntity);

        assertEquals(studentService.getStudent((long)1).getName(), studentEntity.getName());
    }

    @Test
    public void testGetStudentList() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(1);
        studentEntity.setName("Duc");

        List<StudentEntity> studentEntityList = new ArrayList<>();
        studentEntityList.add(studentEntity);

        when(studentService.getStudentList()).thenReturn(studentEntityList);
        assertNotNull(studentService.getStudentList());
    }

    @Test
    public void testFindByNameAndPhone() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(1);
        studentEntity.setName("Duc");

        List<StudentEntity> studentEntityList = new ArrayList<>();
        studentEntityList.add(studentEntity);

        when(studentService.findByNameAndPhone(anyString(), anyString())).thenReturn(studentEntityList);
        assertNotNull(studentService.findByNameAndPhone("Duc", ""));
    }
}
