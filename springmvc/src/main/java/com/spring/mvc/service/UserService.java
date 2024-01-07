package com.spring.mvc.service;

import com.spring.mvc.dao.UserDao;
import com.spring.mvc.model.User;

public interface UserService {
    public int registerUser(User user);
}
