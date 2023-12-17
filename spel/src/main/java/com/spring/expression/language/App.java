package com.spring.expression.language;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"config.xml"});

        //Person person = (Person) context.getBean("person");

        Demo demo = context.getBean("ob", Demo.class);
        Demo demo2 = (Demo) context.getBean("ob");

        System.out.println(demo.hashCode());
        System.out.println(demo2.hashCode());


        System.out.println(demo);
        //System.out.println(person);
    }
}
