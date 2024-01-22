package com.study.sns_study.service;

import com.study.sns_study.entity.User;
import com.study.sns_study.repository.UserRepository;
import com.study.sns_study.util.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(User user) {
        //사용자 등록
        String encodeedPassword = PasswordEncoder.encodePassword(user.getPassword());
        user.setPassword(encodeedPassword);
        userRepository.save(user);
    }


    @Override
    public User validateUser(String username, String password) {
        //사용자 인증
        User user = userRepository.findByUsername(username);
        if (user != null) {
            String encodedPassword=PasswordEncoder.encodePassword(password);
            if(encodedPassword.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }

}
