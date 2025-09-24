package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Student> create(@Valid @RequestBody StudentCreateRequest req,
                                          UriComponentsBuilder uriBuilder) {
        Student saved = service.create(req);
        return ResponseEntity.created(
                uriBuilder.path("/api/students/{id}").buildAndExpand(saved.getId()).toUri()
        ).body(saved);
    }

    @GetMapping
    public ResponseEntity<StudentListResponse> getAll() {
        return ResponseEntity.ok(service.findAllStudents());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}