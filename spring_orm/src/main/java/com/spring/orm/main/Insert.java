package com.spring.orm.main;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class Insert
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        //ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
        StudentDao studentDaoImpl = context.getBean("studentDaoImpl", StudentDao.class);
        Student student = new Student(237, "Musa", "Egypt");
        studentDaoImpl.insert(student);
        System.out.println("Done: ");
    }
}
