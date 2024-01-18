package com.hibernate.springboot;

import com.hibernate.springboot.dao.StudentDao;
import com.hibernate.springboot.entities.Laptop;
import com.hibernate.springboot.entities.Student;
import com.hibernate.springboot.service.LaptopService;
import com.hibernate.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
		System.out.println("Hello");

		Laptop laptop = new Laptop();
		laptop.setName("HP");
		laptop.setLid(1011);

		Student student = new Student();
		student.setName("Shamim");
		student.setRollNo(12);
		student.setLaptop(laptop);

		StudentService studentService = context.getBean("studentService", StudentService.class);
		LaptopService laptopService = context.getBean("laptopService", LaptopService.class);

		laptopService.save(laptop);
		studentService.save(student);

		System.out.println(student);
		//StudentService studentService1 = new StudentService();
		//studentService1.save(student);
	}

}
