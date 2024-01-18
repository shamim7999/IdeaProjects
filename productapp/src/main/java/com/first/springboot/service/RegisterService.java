package com.first.springboot.service;

import com.first.springboot.model.Registered;

import java.util.List;


public interface RegisterService {
    public void registerUser(Registered registered);

    public List<Registered> findRegisteredUsers(String userName, String userPassword);

    public Registered isUserNameAvailable(String userName);
}
