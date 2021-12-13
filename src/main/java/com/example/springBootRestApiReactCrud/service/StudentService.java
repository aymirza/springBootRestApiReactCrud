package com.example.springBootRestApiReactCrud.service;

import com.example.springBootRestApiReactCrud.model.Student;
import com.example.springBootRestApiReactCrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();
        studentRepository.findAll().forEach(studentList::add);
        return studentList;
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void updateStudent(Long id, Student student) {
        Student studentFromDb = studentRepository.findById(id).get();
        System.out.println(studentFromDb.toString());
        studentFromDb.setFirstname(student.getFirstname());
        studentFromDb.setLastname(student.getLastname());
        studentFromDb.setYear(student.getYear());
        studentRepository.save(studentFromDb);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);

    }
}
