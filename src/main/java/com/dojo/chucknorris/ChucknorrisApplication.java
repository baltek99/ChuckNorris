package com.dojo.chucknorris;

import com.dojo.chucknorris.repository.JokeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories(basePackageClasses = JokeRepository.class)
public class ChucknorrisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChucknorrisApplication.class, args);
	}

}
