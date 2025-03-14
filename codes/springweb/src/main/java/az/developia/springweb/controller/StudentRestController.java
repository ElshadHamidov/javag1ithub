package az.developia.springweb.controller;

import az.developia.springweb.entity.Student;
import az.developia.springweb.exception.OurRuntimeException;
import az.developia.springweb.repository.StudentRepository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentRestController {
    private final StudentRepository studentRepository;

    public StudentRestController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student, BindingResult br) {
        if (br.hasErrors()) {
            throw new OurRuntimeException(br);
        }
        System.out.println(student);
        StudentRepository.save(student);
    }
}
