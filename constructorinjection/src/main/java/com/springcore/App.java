package com.springcore;

import com.calc.Addition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello Constructor Injection!" );
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"config.xml", "AdditionConfig.xml"});

        Person person = (Person) context.getBean("person");
        System.out.println(person+"\n");

        Addition addition = (Addition) context.getBean("addition");
        addition.doSum();
        System.out.println(addition+"\n");
        context.registerShutdownHook(); // Responsible for destroy(); calling
    }
}
