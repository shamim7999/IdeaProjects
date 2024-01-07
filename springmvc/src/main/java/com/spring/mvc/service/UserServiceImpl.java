package com.spring.mvc.service;

import com.spring.mvc.dao.UserDao;
import com.spring.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public int registerUser(User user) {
        int i = this.userDao.saveUser(user);
        return i;
    }
}
