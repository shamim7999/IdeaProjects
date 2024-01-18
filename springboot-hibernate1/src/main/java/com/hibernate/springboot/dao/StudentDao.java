package com.hibernate.springboot.dao;

import com.hibernate.springboot.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentDao extends CrudRepository<Student, Integer> {

}
