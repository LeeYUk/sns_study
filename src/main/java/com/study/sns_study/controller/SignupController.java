package com.study.sns_study.controller;

import com.study.sns_study.entity.User;
import com.study.sns_study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @PostMapping("/signup")
    public String signupForm(@ModelAttribute User user){ //회원가입 처리 메소드 회원가입 품을 통해 post할때 해당 메소드가 사용
        userService.registerUser(user);
        return "redirect:/login";//회원가입 후 로그인페이지로 이동
    }
}
