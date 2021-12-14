package com.example.springBootRestApiReactCrud.controller;

import com.example.springBootRestApiReactCrud.model.Student;
import com.example.springBootRestApiReactCrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studentList = studentService.getStudents();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        return new ResponseEntity<>(studentService.getStudentById(id),HttpStatus.OK);
    }

    @GetMapping("/st/{id}")
    public  Student getStudentlet(@PathVariable Long id){
        Student student = studentService.getStudentById(id);
        student.setYear(student.getYear()+10);
        return student;
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student student){
        studentService.updateStudent(id,student);
        return new ResponseEntity<>(studentService.getStudentById(id),HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student student1 = studentService.addStudent(student);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("student","/api/v1/student/"+student1.getId().toString());
        return  new ResponseEntity<>(student1,httpHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
