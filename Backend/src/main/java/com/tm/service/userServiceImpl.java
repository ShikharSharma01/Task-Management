package com.tm.service;

import com.tm.entities.userEntity;
import com.tm.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class userServiceImpl implements userService{
    @Autowired
    private userRepository user;

    @Override
    public userEntity getUser(String userEmail) {
        return user.findByEmail(userEmail);
    }

    @Override
    public void registerUser(userEntity userReg) {
        user.save(userReg);
    }
}
