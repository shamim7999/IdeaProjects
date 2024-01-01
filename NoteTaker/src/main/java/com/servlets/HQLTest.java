package com.servlets;

import com.entities.Note;
import com.helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class HQLTest {
    public static void main(String[] args) {
        Session session = FactoryProvider.getFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query q1 = session.createQuery("delete from Note n where n.title =:x ");

        q1.setParameter("x", "Python");
        int r = q1.executeUpdate();
        System.out.println("Found "+r+" rows.\n");

        transaction.commit();
        session.close();
    }
}
