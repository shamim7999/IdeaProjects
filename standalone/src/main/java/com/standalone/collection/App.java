package com.standalone.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"config.xml"});
        //Person person = context.getBean("person", Person.class);
        // Or by Type-Casting.
        Person person = (Person) context.getBean("person");
        System.out.println(person);
    }
}
