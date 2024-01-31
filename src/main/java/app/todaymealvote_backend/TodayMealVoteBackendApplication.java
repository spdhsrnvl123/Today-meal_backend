package app.todaymealvote_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = "app.todaymealvote_backend")
public class TodayMealVoteBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(TodayMealVoteBackendApplication.class, args);
	}

}
