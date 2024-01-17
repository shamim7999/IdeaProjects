package com.first.springboot;

import com.first.springboot.dao.ProductRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
		System.out.println("Hello");

		//ProductRepository userRepository = context.getBean(ProductRepository.class);

	}

}
