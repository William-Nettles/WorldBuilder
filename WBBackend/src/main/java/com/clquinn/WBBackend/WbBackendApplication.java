package com.clquinn.WBBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.clquinn")
@EntityScan("com.clquinn.models")
@EnableJpaRepositories("com.clquinn.daos")
public class WbBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WbBackendApplication.class, args);
	}

}
