package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repo;

    @Transactional
    public Student createStudent(Student student) {
        if (repo.existsByEmail(student.getEmail())) {
            throw new IllegalArgumentException("Bu email ilə artıq tələbə var");
        }
        if (repo.existsByUsername(student.getUsername())) {
            throw new IllegalArgumentException("Bu username ilə artıq tələbə var");
        }
        return repo.save(student);
    }

    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        return repo.findAll();
    }
}
