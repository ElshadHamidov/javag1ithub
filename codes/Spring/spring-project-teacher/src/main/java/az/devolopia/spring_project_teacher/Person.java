package az.devolopia.spring_project_teacher;

import org.springframework.stereotype.Component;

@Component
public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private Double salary;
    public Person() {
        this.id = 101;
        this.name = "John Doe";
        this.age = 30;
        this.salary = 50000.0;
    }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
    public void printPersonDetails() {
        System.out.println("Person Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: $" + salary);
    }
}
