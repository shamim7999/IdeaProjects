package com.hibernate.springboot.dao;

import com.hibernate.springboot.entities.Answer;
import org.springframework.data.repository.CrudRepository;

public interface AnswerDao extends CrudRepository<Answer, Integer> {
}
