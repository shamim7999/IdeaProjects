package com.hibernate.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        //System.out.println( "Hello World!" );
        //Configuration cfg = new Configuration();
        //cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        System.out.println(factory);
        System.out.println(factory.isClosed());
        System.out.println("\n\n\n");


        Person person = new Person();


        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        /////////////////////////////////////////////
        FileInputStream imageFile = new FileInputStream("/home/shamim/Desktop/khabib.jpeg");
        byte[] imageData = new byte[imageFile.available()];
        imageFile.read(imageData);
        person.setImage(imageData);
        person.setEx(23);
        person.setDate(LocalDate.now());
        person.setName("Shamim");
        
        session.save(person);
        
        
        /////////////////////////////////////////////
        transaction.commit();
        session.close();
        factory.close();
    }
}
