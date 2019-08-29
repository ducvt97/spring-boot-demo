package com.example.test.controller;

import com.example.test.entity.StudentEntity;
import com.example.test.service.StudentService;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {

    @InjectMocks
    private StudentController studentController;

    @Mock
    private StudentService studentService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        studentController.setStudentService(studentService);
    }

    @Test
    public void testAddCourse() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(1);
        studentEntity.setName("Duc");
        studentEntity.setPhone("0123456789");

        when(studentService.addStudent(anyString(), anyString())).thenReturn(studentEntity);

        ResponseEntity response = studentController.addStudent("Duc", "0123456789");
        StudentEntity actualStudentEntity = (StudentEntity) response.getBody();

        assertEquals(actualStudentEntity.getName(), studentEntity.getName());
    }

    @Test
    public void testDeleteCourse(){
        when(studentService.deleteStudent(anyLong())).thenReturn(true);

        ResponseEntity response = studentController.deleteStudent(1);
        Boolean result = (Boolean) response.getBody();

        assertEquals(result, true);
    }

    @Test
    public void testGetStudent() {

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(1);
        studentEntity.setName("Duc");

        when(studentService.getStudent(anyLong())).thenReturn(studentEntity);

        ResponseEntity responseEntity = studentController.getStudent(1);
        StudentEntity actualStudentEntity = (StudentEntity) responseEntity.getBody();

        assertEquals(studentEntity.getName(), actualStudentEntity.getName());
    }

    @Test
    public void testListStudent() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(1);
        studentEntity.setName("Duc");

        List<StudentEntity> studentEntityList = new ArrayList<>();
        studentEntityList.add(studentEntity);

        when(studentService.getStudentList()).thenReturn(studentEntityList);

        ResponseEntity responseEntity = studentController.listStudent();
        List<StudentEntity> actualStudentList = (List<StudentEntity>) responseEntity.getBody();

        assertEquals(actualStudentList.size(), studentEntityList.size());
    }

    @Test
    public void testSearchStudent() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(1);
        studentEntity.setName("Duc");

        List<StudentEntity> studentEntityList = new ArrayList<>();
        studentEntityList.add(studentEntity);

        when(studentService.findByNameAndPhone(anyString(), anyString())).thenReturn(studentEntityList);

        ResponseEntity responseEntity = studentController.searchStudent("Duc", "");
        List<StudentEntity> actualStudentList = (List<StudentEntity>) responseEntity.getBody();

        assertEquals(actualStudentList.size(), studentEntityList.size());
    }
}
