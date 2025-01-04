package com.tm.service;

import com.tm.entities.UserEntity;

public interface UserService {

    String registerUser(UserEntity user);

    UserEntity findByUsername(String userName);
}
