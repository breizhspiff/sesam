package biz.meziant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "biz.meziant.repository")
public class SesamApplication {

	public static void main(String[] args) {
		SpringApplication.run(SesamApplication.class, args);
	}
}
