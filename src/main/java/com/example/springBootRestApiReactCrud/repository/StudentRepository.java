package com.example.springBootRestApiReactCrud.repository;

import com.example.springBootRestApiReactCrud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
