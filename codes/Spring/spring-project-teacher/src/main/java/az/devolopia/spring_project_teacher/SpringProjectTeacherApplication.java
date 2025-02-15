package az.devolopia.spring_project_teacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProjectTeacherApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectTeacherApplication.class, args);
		Book bookBean=run.getBean(Book.class);
		System.out.println(bookBean.getName());
		System.out.println(bookBean.getPrice());
		System.out.println(bookBean.getPageCount());
		Person personBean=run.getBean(Person.class);
		System.out.println(personBean.getName())
		System.out.println(personBean.getAge())
		System.out.println(personBean.getSalary())
	}

}
