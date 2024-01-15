package com.only.test;

import com.only.models.A;
import com.only.models.B;
import com.only.models.Human;
import com.only.models.InZoo;
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
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml", "configA.xml");
        A a = context.getBean("a", A.class);
        System.out.println(a);
        B b = context.getBean("b", B.class);
        System.out.println(b);

        Human human = context.getBean("human1", Human.class);
        System.out.println(human);

        InZoo inZoo = context.getBean("zoo1", InZoo.class);
        System.out.println(inZoo);
    }
}
