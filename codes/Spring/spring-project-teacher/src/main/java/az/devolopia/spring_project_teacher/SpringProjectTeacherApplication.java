package az.devolopia.spring_project_teacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringProjectTeacherApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringProjectTeacherApplication.class, args);

        Employee employeeBean = context.getBean(Employee.class);
        System.out.println("Employee Details:");
        System.out.println("ID: " + employeeBean.getId());
        System.out.println("Name: " + employeeBean.getName());
        System.out.println("Age: " + employeeBean.getAge());
        System.out.println("Salary: " + employeeBean.getSalary());

        Computer computerBean = employeeBean.getComputer();
        if (computerBean != null) {
            System.out.println("\nComputer Assigned to Employee:");
            System.out.println("Brand: " + computerBean.getBrand());
            System.out.println("Price: $" + computerBean.getPrice());
            System.out.println("Color: " + computerBean.getColor());

            RAM ramBean = computerBean.getRam();
            System.out.println("\nRAM Details in Computer:");
            System.out.println("Size: " + ramBean.getSize() + "GB");
            System.out.println("Type: " + ramBean.getType());
            System.out.println("Speed: " + ramBean.getSpeed() + "MHz");
        }

        Computer standaloneComputer = context.getBean(Computer.class);
        System.out.println("\nStandalone Computer Details:");
        System.out.println("Brand: " + standaloneComputer.getBrand());
        System.out.println("Price: $" + standaloneComputer.getPrice());
        System.out.println("Color: " + standaloneComputer.getColor());

        RAM standaloneRam = standaloneComputer.getRam();
        System.out.println("\nStandalone RAM Details:");
        System.out.println("Size: " + standaloneRam.getSize() + "GB");
        System.out.println("Type: " + standaloneRam.getType());
        System.out.println("Speed: " + standaloneRam.getSpeed() + "MHz");
    }
}
