package com.hibernate.project;

import com.hibernate.embedded.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.time.LocalDate;

public class FetchDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        /////////////////////////////////////////////

        Student student = session.load(Student.class, 1);
        System.out.println(student.getName());
        student = session.get(Student.class, 2);
        System.out.println(student.getName());

        /////////////////////////////////////////////
        transaction.commit();
        session.close();
        factory.close();
    }
}
