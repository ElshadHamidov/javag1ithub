package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    private final StudentRepository repo;

    public StudentService(StudentRepository repo) { this.repo = repo; }

    @Transactional
    public Student createStudent(Student student) {
        if (repo.existsByEmail(student.getEmail())) {
            throw new IllegalArgumentException("Bu email ilə artıq tələbə var");
        }
        return repo.save(student);
    }
}