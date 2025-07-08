package az.book.manga;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MangaApplication {
    @Bean
	public ModelMapper modelMapper() {
		ModelMapper m = new ModelMapper();
		return m;
	}
    public static void main(String[] args) {
        SpringApplication.run(MangaApplication.class, args);
    }
}
