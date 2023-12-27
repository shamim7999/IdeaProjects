package com.onetomany;

import com.entity.Address;
import com.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println( "Hello Hibernate World!" );

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        /////////////////////////////////////////////

        Address a1 = new Address(101, "Perm Address", "Cumilla");
        Address a2 = new Address(102, "Present Address", "Dhaka");

        List<Address> addresses = new ArrayList<>();
        addresses.add(a1);
        addresses.add(a2);

        Employee em = new Employee();
        em.setAddress(addresses);
        em.setId(999);
        em.setName("Shamim");

        session.save(a1);
        session.save(a2);
        session.save(em);
        /////////////////////////////////////////////
        transaction.commit();
        session.close();
        factory.close();
    }
}
