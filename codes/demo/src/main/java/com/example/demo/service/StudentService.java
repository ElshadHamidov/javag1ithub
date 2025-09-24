package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Student create(StudentCreateRequest req) {
        if (repo.existsByEmail(req.getEmail())) {
            throw new IllegalArgumentException("Bu email artıq mövcuddur");
        }
        Student s = new Student();
        s.setFirstName(req.getFirstName().trim());
        s.setLastName(req.getLastName().trim());
        s.setEmail(req.getEmail().toLowerCase().trim());
        s.setBirthDate(req.getBirthDate());
        return repo.save(s);
    }

    @Transactional(readOnly = true)
    public StudentListResponse findAllStudents() {
        List<Student> all = repo.findAll();
        StudentListResponse response = new StudentListResponse();
        response.setStudents(all);
        return response;
    }

    @Transactional
    public void deleteStudent(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Bu ID-li tələbə tapılmadı: " + id);
        }
        repo.deleteById(id);
    }
}