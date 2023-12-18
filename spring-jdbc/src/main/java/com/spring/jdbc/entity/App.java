package com.spring.jdbc.entity;

import com.spring.jdbc.dao.TesterDao;
import com.spring.jdbc.dao.TesterDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"config.xml"});
        //JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        TesterDao testerDao = (TesterDao) context.getBean("testerDaoImpl"); // TesterDao is Interface
        // TesterDao testerDao = (TesterDaoImpl) context.getBean("testerDaoImpl"); ---> This also works --> TesterDaoImpl is Class

        String name;
        String age;

        Scanner in = new Scanner(System.in);

        while(true) {
            System.out.print("Enter Name: ");
            name = in.next();

            System.out.print("Enter Age: ");
            age = in.next();

            if(Integer.parseInt(age) < 0) {
                break;
            }
            Tester tester = (Tester) context.getBean("tester");
            tester.setName(name);
            tester.setAge(age);

            testerDao.insert(tester);
        }
    }
}
