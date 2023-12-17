package com.springcore;

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
        System.out.println( "Hello init, destroy ---> Beans-Life-Cycle-Using-Interface!");
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"config.xml", "annotationConfig.xml"});
        context.registerShutdownHook();

        Pepsi pespi1 = (Pepsi) context.getBean("pepsi1");
        System.out.println(pespi1);

        Example example = (Example) context.getBean("example");
        System.out.println(example);
    }
}
