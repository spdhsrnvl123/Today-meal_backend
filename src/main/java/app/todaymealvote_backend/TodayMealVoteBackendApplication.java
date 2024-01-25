package app.todaymealvote_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TodayMealVoteBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(TodayMealVoteBackendApplication.class, args);
	}

}
