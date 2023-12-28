package com.onetomany;

import com.entity.Address;
import com.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Fetch {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        ///////////////////////

        //Employee employee = new Employee();
        Address address = (Address) session.get(Address.class, 101);
        System.out.println(address);
        ///////////////////////
        transaction.commit();
        session.close();
        factory.close();
    }
}
