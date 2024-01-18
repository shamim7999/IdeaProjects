package com.hibernate.springboot.service;

import com.hibernate.springboot.dao.LaptopDao;
import com.hibernate.springboot.dao.StudentDao;
import com.hibernate.springboot.entities.Laptop;
import com.hibernate.springboot.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {
    @Autowired
    private LaptopDao laptopDao;

    public void save(Laptop laptop) {
        System.out.println(laptop);
        this.laptopDao.save(laptop);
    }
}
