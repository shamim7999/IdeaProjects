package com.first.springboot.service;

import com.first.springboot.dao.RegisterRepository;
import com.first.springboot.model.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService{
    @Autowired
    private RegisterRepository registerRepository;

    @Override
    public void registerUser(Registered registered) {
        this.registerRepository.save(registered);
    }

    @Override
    public List<Registered> findRegisteredUsers(String userName, String userPassword) {
        return this.registerRepository.findRegisteredUsers(userName, userPassword);
    }

    @Override
    public Registered isUserNameAvailable(String userName) {
        return this.registerRepository.isUserNameAvailable(userName);
    }
}
