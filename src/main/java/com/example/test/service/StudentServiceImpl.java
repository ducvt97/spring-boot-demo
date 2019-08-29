package com.example.test.service;

import com.example.test.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.test.repository.StudentRepository;

import java.util.ArrayList;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public ArrayList<StudentEntity> getStudentList(){
        try {
            return (ArrayList<StudentEntity>) studentRepository.findAll();
        } catch (Exception e){
            throw e;
        }
    }

    public StudentEntity getStudent(long id){
        try {
            //return studentIGenericDao.findOne(id);
            return studentRepository.getOne(id);
        } catch (Exception e){
            throw new ArithmeticException("Failed to get student");
        }
    }

    public StudentEntity addStudent(String name, String phone){
        try {
            StudentEntity studentEntity = new StudentEntity(name, phone);
            studentRepository.save(studentEntity);
            return studentEntity;
        } catch (Exception e){
            throw new ArithmeticException("Failed to add studentEntity");
        }
    }

    public boolean deleteStudent(long id){
        try {
            studentRepository.deleteById(id);
            return true;
        } catch (Exception e){
            throw new ArithmeticException("Failed to delete student");
        }
    }

    public ArrayList<StudentEntity> findByNameAndPhone(String name, String phone){
        try {
            if(name == null) {
                name = "";
            }
            if(phone == null){
                phone = "";
            }
            return (ArrayList<StudentEntity>) studentRepository.findByNameAndPhone(name, phone);
        }catch (Exception e){
            throw new ArithmeticException("Failed to find student");
        }
    }
}
