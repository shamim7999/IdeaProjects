package com.spring.jdbc.entity;

import com.spring.jdbc.dao.TesterDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class App
{

    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        //JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        TesterDao testerDao = (TesterDao) context.getBean("testerDaoImpl"); // TesterDao is Interface
        // TesterDao testerDao = (TesterDaoImpl) context.getBean("testerDaoImpl"); ---> This also works --> TesterDaoImpl is Class

        String name;
        String age;

        Scanner in = new Scanner(System.in);
        int cc;
        System.out.println("Enter 1 for insert: ");
        System.out.println("Enter 2 for update: ");
        System.out.println("Enter 3 for delete: ");
        System.out.println("Enter 4 for Show Records for a Given ID: ");
        System.out.println("Enter 5 for show All records:  ");
        //cc = in.nextInt();

        Tester tester = (Tester) context.getBean("tester");

        while(true) {
            System.out.print("Enter Choice: ");
            cc = in.nextInt();
            if(cc == 1) {
                System.out.print("Enter Name: ");
                name = in.next();
                System.out.print("Enter Age: ");
                age = in.next();
                tester.setName(name);
                tester.setAge(age);

                testerDao.insert(tester);
            } else if(cc == 2) {
                System.out.print("Enter ID: ");
                int id = in.nextInt();
                System.out.print("Enter Name: ");
                name = in.next();
                System.out.print("Enter Age: ");
                age = in.next();

                tester.setName(name);
                tester.setAge(age);
                tester.setId(id);

                testerDao.change(tester);

            } else if(cc == 3) {
                System.out.print("Enter ID: ");
                int id = in.nextInt();
                tester.setId(id);

                testerDao.delete(tester);
            } else if(cc == 4) {
                System.out.print("Enter ID: ");
                int id = in.nextInt();
                tester = testerDao.showAllRecordsById(id);
                System.out.println(tester);
            } else if(cc == 5){
                List<Tester> testers = testerDao.showAllRecords();
                testers.stream().forEach(System.out::println);
            }
        }
    }
}