package az.developis.stringweb.stringweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "az.developis.stringweb")
public class StringwebApplication {
    public static void main(String[] args) {
        SpringApplication.run(StringwebApplication.class, args);
    }
}
