package com.study.sns_study.service;

import com.study.sns_study.entity.Post;
import com.study.sns_study.entity.User;

import java.util.List;

public interface UserService {

    void registerUser(User user);
    User validateUser(String username, String password);

}
