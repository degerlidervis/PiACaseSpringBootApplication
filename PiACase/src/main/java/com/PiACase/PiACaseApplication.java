package com.PiACase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan({"com.PiACase.entity", "com.PiACase.dto"})
@EnableJpaRepositories(basePackages = "com.PiACase")
@ComponentScan
@EnableCaching
public class PiACaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiACaseApplication.class, args);
	}

}
