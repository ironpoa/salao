package com.targettrust.salao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SalaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalaoApplication.class, args);
	}

}
