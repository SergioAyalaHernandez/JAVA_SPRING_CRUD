package com.apiSergio.SergioCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.apiSergio.SergioCrud.models")
public class SergioCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SergioCrudApplication.class, args);
	}

}
