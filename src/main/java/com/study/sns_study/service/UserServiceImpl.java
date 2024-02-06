package com.study.sns_study.service;

import com.study.sns_study.entity.User;
import com.study.sns_study.repository.UserRepository;
import com.study.sns_study.util.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(User user) {
        //사용자 등록
        String encodeedPassword = PasswordEncoder.encodePassword(user.getPassword()); //입력받은 password를 암호화한다음 데이터베이스에 저장 회원 등록
        user.setPassword(encodeedPassword);
        userRepository.save(user);
    }


    @Override
    public User validateUser(String username, String password) { // 회원정보를 조회하고 일치하면 로그인

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
