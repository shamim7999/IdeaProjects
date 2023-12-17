package com.config.without.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Student student = (Student) context.getBean("firstStudent");
        System.out.println(student);

        Person person = (Person) context.getBean("getPerson");
        Person person2 = (Person) context.getBean("getPerson2");
        System.out.println(person);
        System.out.println(person.hashCode()+"\n"+person2.hashCode());
    }
}
