package com.spring.orm.main;

import com.spring.orm.dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Update {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDaoImpl = context.getBean("studentDaoImpl", StudentDao.class);
        studentDaoImpl.updateStudent(235);
    }
}
