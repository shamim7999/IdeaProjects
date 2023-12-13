package com.springcore;

import com.collections.Emp;
import com.ref.A;
import com.ref.B;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// We are doing setter injection here......
// We are doing setter injection here......
// We are doing setter injection here......
// We are doing setter injection here......
// We are doing setter injection here......
// We are doing setter injection here......
// We are doing setter injection here......
// We are doing setter injection here......

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        //Student student = new Student(12, "Shamim", "Dhaka");
        //System.out.println(student);
        ApplicationContext context = new ClassPathXmlApplicationContext( new String[]{"spring.xml", "cconfig.xml", "ref.xml"});
        Student student1 = (Student) context.getBean("student1");
        Student student2 = (Student) context.getBean("student2");
        Student student3 = (Student) context.getBean("student3");

        System.out.println(student1+"\n"+student2+"\n"+student3+"\n");

        Vehicle vehicle = (Vehicle) context.getBean("vehicle");
        vehicle.drive();

        Emp emp = (Emp) context.getBean("emp");
        System.out.println(emp+"\n");

        A a = (A) context.getBean("aref");
        System.out.println(a+"\n");

        B b = (B) context.getBean("bref");
        System.out.println(b);
    }
}
