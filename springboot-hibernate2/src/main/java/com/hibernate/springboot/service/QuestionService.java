package com.hibernate.springboot.service;

import com.hibernate.springboot.dao.QuestionDao;
import com.hibernate.springboot.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private QuestionDao questionDao;
    public void save(Question question) {
        this.questionDao.save(question);
    }
}
