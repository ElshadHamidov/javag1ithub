public package az.devolopia.spring_project_teacher;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public Computer computerBean() {
        return new Computer();
    }

    @Bean
    public RAM ramBean() {
        return new RAM(16, "DDR4", 3200);
    }
}
 {
    
}
