package com.onetoone;

import com.entity.Answer;
import com.entity.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello Hibernate World!" );

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        /////////////////////////////////////////////

        Question q1 = new Question();
        q1.setQuestionId(234);
        q1.setQuestion("What is Java?");

        Answer a3 = new Answer();
        a3.setAnswer("Java is Pure OOP.");
        a3.setAnswerId(456);

        q1.setAnswer(a3);
        session.save(q1);


//        Question q2 = new Question();
//        q2.setQuestion("Is C++ OOP?");
//        Answer a1 = new Answer();
//        a1.setAnswer("C++ is not pure OOP.");
//        q2.setAnswer(a1);
//        session.save(q2);
//
//
//        Question q3 = new Question();
//        q3.setQuestion("Is Python hard?");
//        Answer a2 = new Answer();
//        a2.setAnswer("Python is Easy.");
//        q3.setAnswer(a2);
//        session.save(q3);


        /////////////////////////////////////////////
        transaction.commit();
        session.close();
        factory.close();
    }
}
