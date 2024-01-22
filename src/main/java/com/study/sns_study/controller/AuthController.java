package com.study.sns_study.controller;

import com.study.sns_study.entity.User;
import com.study.sns_study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/auth")
public class AuthController {



    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        userService.registerUser(user);
        return "등록 성공!";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password){
        User user = userService.validateUser(username,password);
        if(user!=null){
            return "로그인 성공!";
        }
        else {
            return "잘못된 자격증명";
        }
    }
}
