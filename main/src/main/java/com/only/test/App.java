package com.only.test;

import com.only.models.A;
import com.only.models.B;
import org.springframework.context.ApplicationContext;
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
        ApplicationContext context = new ClassPathXmlApplicationContext("configA.xml");
        A a = context.getBean("a", A.class);
        System.out.println(a);
        B b = context.getBean("b", B.class);
        System.out.println(b);
    }
}
