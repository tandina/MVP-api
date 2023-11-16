package com.mvp.P6mvpapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class P6MvpApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(P6MvpApiApplication.class, args);
	}

}
