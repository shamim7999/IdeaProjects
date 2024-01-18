package com.hibernate.springboot.service;

import com.hibernate.springboot.dao.AnswerDao;
import com.hibernate.springboot.entities.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    @Autowired
    private AnswerDao answerDao;
    public void save(Answer answer) {
        this.answerDao.save(answer);
    }
}
