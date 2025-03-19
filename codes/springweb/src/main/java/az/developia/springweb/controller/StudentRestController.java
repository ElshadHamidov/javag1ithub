package az.developia.springweb.controller;

import az.developia.springweb.entity.Student;
import az.developia.springweb.exception.OurRuntimeException;
import az.developia.springweb.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentRestController {
    private final StudentRepository studentRepository;

    public StudentRestController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/add")
    public void addStudent(@Valid @RequestBody Student student, BindingResult br) {
        if (br.hasErrors()) {
            throw new OurRuntimeException(br);
        }
        System.out.println(student);
        studentRepository.save(student);
    }

    @PutMapping("/update")
    public void update(@Valid @RequestBody Student student, BindingResult br) {
        if (br.hasErrors()) {
            throw new OurRuntimeException(null, "melumatlarin tamliginda problem var");
        }

        if (student.getId() == null || student.getId() == 0) {
            throw new OurRuntimeException(null, "id mutleqdir");
        }

        studentRepository.findById(student.getId())
                .orElseThrow(() -> new OurRuntimeException(null, "id tapilmadi"));

        studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
        if (id == null || id <= 0) {
            throw new OurRuntimeException(null, "id mutleqdir!");
        }

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new OurRuntimeException(null, "id tapilmadi!"));

        studentRepository.deleteById(student.getId());

        return ResponseEntity.ok("Student deleted successfully");
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Integer id) {
        if (id == null || id <= 0) {
            throw new OurRuntimeException(null, "id mutleqdir!");
        }

        return studentRepository.findById(id)
                .orElseThrow(() -> new OurRuntimeException(null, "id tapilmadi!"));
    }
}
