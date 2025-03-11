package az.developia.springweb.controller;

import az.developia.springweb.entity.Student;
import az.developia.springweb.repository.StudentDAO;
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