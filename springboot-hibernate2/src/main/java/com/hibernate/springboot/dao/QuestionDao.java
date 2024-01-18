package com.hibernate.springboot.dao;

import com.hibernate.springboot.entities.Answer;
import com.hibernate.springboot.entities.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionDao extends CrudRepository<Question, Integer> {
}