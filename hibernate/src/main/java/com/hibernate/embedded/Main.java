package com.hibernate.embedded;

import com.hibernate.project.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Working on Employee Table..\n\n");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        /////////////////////////////////////////////


        Employee employee = new Employee();
        employee.setName("Shamim");
        employee.setCity("Dhaka");

        Certificate certificate = new Certificate();
        certificate.setCourse("Java");
        certificate.setDuration("2 Months");


        employee.setCertificate(certificate);
        session.save(employee);


        employee = new Employee();
        employee.setName("Sadman");
        employee.setCity("Sylhet");

        certificate = new Certificate();
        certificate.setCourse("C#");
        certificate.setDuration("4 Months");

        employee.setCertificate(certificate);
        session.save(employee);

        /////////////////////////////////////////////
        transaction.commit();
        session.close();
        factory.close();
    }
}
