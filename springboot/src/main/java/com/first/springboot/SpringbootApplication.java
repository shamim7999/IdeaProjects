package com.first.springboot;

import com.first.springboot.dao.UserRepository;
import com.first.springboot.entities.Test;
import com.first.springboot.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
		System.out.println("Hello");

		UserRepository userRepository = context.getBean(UserRepository.class);

//		User user = new User();
//		user.setName("Ahmed");
//		user.setCity("Cumilla");
//
//		System.out.println(userRepository.save(user));

//		User user1 = new User();
//		user1.setName("Ahmed");
//		user1.setCity("Chittagong");
//		User user2 = new User("Jony", "Khilgaon");
//		User user3 = new User("Rajib", "Malaysia");
//
//		List<User> users = List.of(user1, user2, user3);
//
//		Iterable<User> results = userRepository.saveAll(users);
//		results.forEach(System.out::println);

//		User user1 = userRepository.findById(53).get();
//		user1.setName("Zamilaaa");
//		userRepository.save(user1);

		//userRepository.save(user1);

		Iterable<User> results = userRepository.findByNameAndCity("Shamim", "Dhaka");
		results.forEach(System.out::println);

		results = userRepository.findAllByCityInOrderByName(Arrays.asList("Aftabnagar", "Chittagong"));
		results.forEach(System.out::println);
		System.out.println("_______________________________________________________________________");
		results = userRepository.getAllUser("Shamim", "Dhaka");
		results.forEach(System.out::println);
		System.out.println("_______________________________________________________________________");
		results = userRepository.getAllUserByHqlAnotherWay("Shamim", "Dhaka");
		results.forEach(System.out::println);
		System.out.println("_______________________________________________________________________");
		results = userRepository.getAllUserByNativeQuery("Shamim", "Dhaka");
		results.forEach(System.out::println);
	}

}
