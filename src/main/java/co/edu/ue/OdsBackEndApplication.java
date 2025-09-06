package co.edu.ue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"co.edu.ue.jpa"})
@EntityScan(basePackages = {"co.edu.ue.entity"})
@ComponentScan(basePackages = {"co.edu.ue.controller", "co.edu.ue", "co.edu.ue.repository", "co.edu.ue.services"})
public class OdsBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(OdsBackEndApplication.class, args);
	}

}
