package com.example.springBootRestApiReactCrud.service;


import com.example.springBootRestApiReactCrud.model.Student;

import java.util.List;

public interface IStudentService {

    List<Student> getStudents();
    Student getStudentById(Long id);
    Student addStudent(Student student);
    void updateStudent(Long id,Student student);
    void deleteStudent(Long id);



}
