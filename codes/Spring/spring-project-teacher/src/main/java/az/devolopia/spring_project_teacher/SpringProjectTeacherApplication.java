package az.devolopia.spring_project_teacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringProjectTeacherApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringProjectTeacherApplication.class, args);

        Home homeBean1 = context.getBean(Home.class);
        System.out.println("\nHome 1 Details:");
        System.out.println("ID: " + homeBean1.getId());
        System.out.println("Address: " + homeBean1.getAddress());
        System.out.println("Color: " + homeBean1.getColor());

        Home homeBean2 = context.getBean(Home.class);
        System.out.println("\nHome 2 Details:");
        System.out.println("ID: " + homeBean2.getId());
        System.out.println("Address: " + homeBean2.getAddress());
        System.out.println("Color: " + homeBean2.getColor());

        context.close();
    }
}
