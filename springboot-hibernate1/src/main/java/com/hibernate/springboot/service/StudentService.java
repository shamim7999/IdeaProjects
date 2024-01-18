package com.hibernate.springboot.service;

import com.hibernate.springboot.dao.StudentDao;
import com.hibernate.springboot.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public void save(Student student) {
        System.out.println(student);
        this.studentDao.save(student);
    }
}
