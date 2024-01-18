package com.hibernate.springboot.dao;

import com.hibernate.springboot.entities.Laptop;
import com.hibernate.springboot.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface LaptopDao extends CrudRepository<Laptop, Integer> {

}

