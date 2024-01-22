package com.study.sns_study.service;

import com.study.sns_study.entity.User;

public interface UserService {
    void registerUser(User user);
    User validateUser(String username, String password);
}
