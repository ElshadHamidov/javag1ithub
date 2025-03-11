package az.developis.stringweb.repository;

import az.developis.stringweb.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO {
    private final JdbcTemplate jdbcTemplate;

    public StudentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveStudent(Student student) {
        String sql = "INSERT INTO students (name, age) VALUES (?, ?)";
        jdbcTemplate.update(sql, student.getName(), student.getAge());
    }
}
