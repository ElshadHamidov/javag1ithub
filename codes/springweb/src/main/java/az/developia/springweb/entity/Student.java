package az.developia.springweb.entity;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 40, message = "Name must be between 2 and 40 symbols")
    private String name;

    private int age;
    private String surname;

    public Student() {}

    public Student(String name, int age, String surname) {
        this.name = name;
        this.age = age;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
