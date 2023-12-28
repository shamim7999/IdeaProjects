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

        Address a1 = new Address(1, "Perm Address", "Cumilla");
        Address a2 = new Address(2, "Present Address", "Dhaka");

        List<Address> addresses = new ArrayList<>();
        addresses.add(a1);
        addresses.add(a2);

        Employee em = new Employee();
        em.setAddress(addresses);
        em.setId(123);
        em.setName("Shamim");

        a1.setEmployee(em);
        a2.setEmployee(em);

        session.save(a1);
        session.save(a2);
        session.save(em); // --> Data Database a gese..

        em.setName("Sarker"); // --> Eta deoa te Data Update hobe ekhon.
        
        //Address address = (Address) session.get(Address.class, 101);

        //System.out.println(address.getId()+" "+address.getAddressType()+" "+address.getAddress()+" "+address.getEmployee().getId());

        // Why not sout(address); ?

        //System.out.println(address.toString());
        /////////////////////////////////////////////
        transaction.commit();

        Employee employee = session.get(Employee.class, 123);
        System.out.println(employee.getName());

        session.close();
        factory.close();
    }
}
