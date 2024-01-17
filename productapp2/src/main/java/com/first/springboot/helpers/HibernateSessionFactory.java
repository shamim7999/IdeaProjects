package com.first.springboot.helpers;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
    public static SessionFactory getSession() {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.orm.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        return factory;
    }
}
