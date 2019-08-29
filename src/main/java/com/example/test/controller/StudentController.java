package com.example.test.controller;

import com.example.test.entity.StudentEntity;
import com.example.test.service.StudentService;
import org.assertj.core.util.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<StudentEntity> addStudent(@RequestParam(value = "name", required = true) String name,
                                                    @RequestParam(name = "phone", required = true) String phone){
        try{
            return ResponseEntity.ok().body(studentService.addStudent(name, phone));
        }catch (Exception e){
            throw e;
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseEntity<List<StudentEntity>> listStudent(){
        try {
            return ResponseEntity.ok().body(studentService.getStudentList());
        }catch (Exception e){
            throw e;
        }
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<StudentEntity> getStudent(@PathVariable(value="id", required = true) long id){
        try {
            StudentEntity studentEntity = studentService.getStudent(id);
            return ResponseEntity.ok().body(studentEntity);
        }catch (Exception e){
            throw e;
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity<Boolean> deleteStudent(@PathVariable(value = "id", required = true) long id){
        try{
            return ResponseEntity.ok().body(studentService.deleteStudent(id));
        }
        catch (Exception e){
            throw e;
        }
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<List<StudentEntity>> searchStudent(@RequestParam(value = "name", required = false) String name,
                                                             @RequestParam(value = "phone", required = false) String phone){
        try{
            return ResponseEntity.ok().body(studentService.findByNameAndPhone(name, phone));
        }
        catch (Exception e){
            throw e;
        }
    }

    // Only for testing
    @VisibleForTesting
    void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
