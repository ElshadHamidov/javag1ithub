package az.devolopia.spring_project_teacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringProjectTeacherApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringProjectTeacherApplication.class, args);

        Book bookBean = context.getBean(Book.class);
        System.out.println("Book Details:");
        System.out.println("Name: " + bookBean.getName());
        System.out.println("Price: " + bookBean.getPrice());
        System.out.println("Page Count: " + bookBean.getPageCount());

        Person personBean = context.getBean(Person.class);
        System.out.println("\nPerson Details:");
        System.out.println("Name: " + personBean.getName());
        System.out.println("Age: " + personBean.getAge());
        System.out.println("Salary: " + personBean.getSalary());

        Computer computerBean = context.getBean(Computer.class);
        System.out.println("\nComputer Details:");
        System.out.println("ID: " + computerBean.getId());
        System.out.println("Brand: " + computerBean.getBrand());
        System.out.println("Price: $" + computerBean.getPrice());
        System.out.println("Color: " + computerBean.getColor());

        RAM ramBean = context.getBean(RAM.class);
        System.out.println("\nRAM Details:");
        System.out.println("Size: " + ramBean.getSize() + "GB");
        System.out.println("Type: " + ramBean.getType());
        System.out.println("Speed: " + ramBean.getSpeed() + "MHz");
    }
}
