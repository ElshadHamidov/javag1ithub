package az.book.manga.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Profile(value = {"development"})
public class DevSheduler{

	@Scheduled(fixedRate = 2000)
	public void doIt() {
		System.out.println("dev sheduler");
	}
}