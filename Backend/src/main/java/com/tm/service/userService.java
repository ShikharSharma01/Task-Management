package com.tm.service;

import com.tm.entities.userEntity;

public interface userService {
    userEntity getUser(String userEmail);

    void registerUser(userEntity user);
}
