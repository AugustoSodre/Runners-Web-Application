package augusto.github.runners;

import augusto.github.runners.run.Location;
import augusto.github.runners.run.Run;
import foo.bar.WelcomeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	//log.info("Message")

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			Run run = new Run(1, "First test", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 4, Location.OUTDOOR);
			log.info("Run: " + run);
		};
	}

}
