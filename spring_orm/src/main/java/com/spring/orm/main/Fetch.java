package com.spring.orm.main;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.stream.Collectors;

public class Fetch {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDaoImpl = context.getBean("studentDaoImpl", StudentDao.class);

        List<Student> students = studentDaoImpl.getAll().stream()
                .collect(Collectors.toList());
        students.forEach(System.out::println);

        System.out.println(studentDaoImpl.getStudent(235));
        System.out.println(studentDaoImpl.getStudent(235));
    }
}
