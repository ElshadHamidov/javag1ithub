package az.developis.stringweb.controller;

import az.developis.stringweb.entity.Student;
import az.developis.stringweb.repository.StudentDAO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentRestController {
    private final StudentDAO studentDAO;

    public StudentRestController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        studentDAO.saveStudent(student);
        return "Student added successfully!";
    }
}
